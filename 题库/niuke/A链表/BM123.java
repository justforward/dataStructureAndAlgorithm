package 题库.niuke.A链表;

/**
 * @author tandi
 * @date 2023/3/18 下午2:53
 */
public class BM123 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }

    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    // 在指定范围内翻转链表
    // 先找到m的前一个节点
    // 然后记录n的后一个节点，将m到n之间的链表进行翻转
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 先找到m的第一个节点，
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode root = dummy;

        int index = 0;
        while (index < m - 1) {
            root = root.next;
            index++;
        }

        // m 的前一个节点
        ListNode pre = root;

        while (n > index) {
            root = root.next;
            index++;
        }

        //n指向的节点
        ListNode tail = root;
        ListNode next = tail.next;
        tail.next = null;
        ListNode begin = pre.next;
        pre.next = ReverseList(begin);
        begin.next = next;
        return dummy.next;

    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode root = dummy;
        ListNode pre = dummy;

        while (root != null) {
            // 第一个
            ListNode begin = pre.next;
            for (int i = 0; i < k && root != null; i++) {
                root = root.next;
            }
            if (root == null) {
                break;
            }
            // 保留下一个节点
            ListNode next = root.next;
            root.next = null;
            //翻转之后，之前的前一个节点指向最新的头
            pre.next = (ReverseList(begin));
            // 翻转之后，之前的第一个节点对应下一个，
            begin.next = next;
            pre = begin;
            root = begin;
        }

        return dummy.next;

    }


}
