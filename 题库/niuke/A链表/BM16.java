package 题库.niuke.A链表;

/**
 * @author tandi
 * @date 2023/3/18 下午8:14
 */
public class BM16 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }

    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                while (cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
