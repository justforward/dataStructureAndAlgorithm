package 题库.niuke.A链表;

/**
 * @author tandi
 * @date 2023/3/18 下午3:58
 */
public class BM6 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;

            }
        }
        return false;
    }
}
