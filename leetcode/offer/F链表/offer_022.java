package leetcode.offer.F链表;


/*
    判断这个链表的环入口？
    1）快慢指针：快指针走两步，慢指针走一步，等到相遇的时候，返回
    2)快指针到头节点后，两个指针在不相遇之前，继续进行移动，直到相遇之后 返回。
 */

public class offer_022 {
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


    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break; // 快慢指针相遇
        }
        if (slow != fast) return null;

        fast = head;
        while (slow != fast) { // 两个相遇的位置
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }
}
