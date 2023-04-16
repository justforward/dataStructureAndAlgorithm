package 题库.offer.F链表;

/*
    链表排序：不改变

    1、找到链表的中点
    2、翻转链表的后半段
    3、交替链表进行合并
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


    public void reorderList(ListNode head) {
        ListNode leftEnd = middle(head);
        ListNode rightEnd = leftEnd.next;
        leftEnd = null;
        // 对rightend进行翻转
        ListNode rightStart = reverse(rightEnd);

        // 合并两个链表
        merge(head, rightStart);
    }


    public void merge(ListNode leftStart, ListNode rightStart) {
        while (rightStart != null) {
            ListNode tmpLeft = leftStart.next;
            ListNode tmpRight = rightStart.next;
            leftStart.next = rightStart;
            rightStart.next = tmpLeft;
            leftStart = tmpLeft;
            rightStart = tmpRight;
        }
    }

    public ListNode middle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 兼容偶数和奇数的情况
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 返回左边的节点
        return slow;
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
}
