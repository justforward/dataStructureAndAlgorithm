package leetcode.offer.F链表;

/*
    链表排序：不改变
 */
public class offer_026 {
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

    int len = 0;

    public void reorderList(ListNode head) {
        ListNode reverse = reverse(head);
        // 根据奇偶判断
        for (int i = 0; i < len/2; i++) {

                head = head.next;
            reverse = reverse.next;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            len++;
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
