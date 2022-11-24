package leetcode.offer.F链表;


/*
    题目：链表中，删除倒数第n个节点


    1）虚指针：每次遍历的时候需要进行从虚指针上进行遍历
    2）同向双指针
      left right right-left=n 这样right指向最后一个节点的时候，left指向倒是第n个节点
    3）返回整个虚指针的next
 */
public class offer_021 {
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


    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚指针

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            // 往前走N步
            fast = fast.next;
        }


        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;

    }
}
