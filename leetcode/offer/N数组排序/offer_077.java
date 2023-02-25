package leetcode.offer.N数组排序;

/**
 * @author tandi
 * @date 2023/2/23 下午10:09
 */
public class offer_077 {

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

    class Solution {
        public ListNode sortList(ListNode head) {
            // 链表的归并排序
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head, fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode mid = slow.next;
            slow.next = null;
            // 一直切割到只剩下两个
            ListNode left = sortList(head);
            ListNode right = sortList(mid);
            ListNode h = new ListNode(0);
            ListNode res = h;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    h.next = left;
                    left = left.next;
                } else {
                    h.next = right;
                    right = right.next;
                }
                h = h.next;
            }
            h.next = left != null ? left : right;
            return res.next;
        }
    }


}