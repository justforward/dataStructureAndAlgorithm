package leetcode.offer.F链表;

/*
    1）找到中间节点进行翻转
    2）根据leftBegin 和 rightBegin 判断是否是回文
 */
public class offer_027 {
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

    public boolean isPalindrome(ListNode head) {
//        if (head.next != null && head.next.next == null) {
//            return head.val == head.next.val;
//        }

        ListNode leftEnd = middle(head);
        ListNode rightEnd = leftEnd.next;
        leftEnd = null;
        ListNode rightStart = reverse(rightEnd);

        return check(head, rightStart);
    }

    public boolean check(ListNode leftStart, ListNode endStart) {
        while (endStart != null) {
            if (leftStart.val != endStart.val) {
                return false;
            }
            leftStart = leftStart.next;
            endStart = endStart.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 找到中间的节点
    public ListNode middle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 存在两个中间节点的情况，需要返回第一个中间节点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
