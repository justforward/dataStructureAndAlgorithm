package 题库.interview;


/*
    消除数组中重复元素：
        1）使用一个缓冲区HashMap 如果出现一次就进行删除操作
        2）不使用缓冲区的实现？时间换空间的方式，两层for循环

 */


import java.util.HashMap;

public class i_02_01 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode removeDuplicateNodes_solution1(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode left = head;
        //ListNode right = dummy.next;
        while (left != null) {
            if (map.containsKey(left.val)) {
                // 包含这个
                ListNode next = left.next;
                pre.next = next;
                left = next;
            } else {
                map.put(left.val, 1);
                pre = pre.next;
                left = left.next;
            }
        }
        return dummy.next;
    }

    public ListNode removeDuplicateNodes_solution2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode left = head;
        while (left != null) {
            ListNode right = left.next;
            ListNode pre = left;
            while (right != null) {
                if (right.val == left.val) {
                    ListNode next = right.next;
                    pre.next = next;
                    right = next;
                } else {
                    pre = pre.next;
                    right = right.next;
                }
            }
            left = left.next;
        }

        return dummy.next;
    }
}
