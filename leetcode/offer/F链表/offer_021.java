package leetcode.offer.F链表;


/*
    删除n这个节点
    同向双指针：left right right-left=n 这样right指向最后一个节点的时候，left指向倒是第n个节点
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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode right = dummy.next;
        ListNode left = dummy.next;
        while (n-- > 0) {
            right = right.next;
        }

        if (right == null) return dummy.next;

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        if (left.next != null) {
            left.next = left.next.next;
        }

        return dummy.next;

    }
}
