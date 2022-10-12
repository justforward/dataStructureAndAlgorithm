package leetcode.day;


import java.util.HashMap;

/*
    统计nums 每次遍历找？
 */
public class leetcode_817 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int numComponents(ListNode head, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        ListNode pre = head;
        int preNum = 0;
        while (pre != null) {
            int val = pre.val;
            if (map.containsKey(val) && map.get(val) > 0) {
                // 前面的数据+1
                preNum++;
                //将hashmap里面的结果进行--
                map.put(val, map.get(val) - 1);
            } else {
                if (preNum > 0) {
                    res++;
                    preNum = 0;
                }
            }
            pre = pre.next;
        }

        if (preNum > 0) {
            res++;
        }

        return res;
    }
}
