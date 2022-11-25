package leetcode.offer.F链表;

/*
    翻转链表:

    1）初始指针是pre=null，当前指向cur
    2）每次记录前一个节点进行移动
 */
public class offer_024 {

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

    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode pre = null;
        // 得到head指向null
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
