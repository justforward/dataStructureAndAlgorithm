package 题库.offer.F链表;

/*
    两个链表相加。从最尾处进行相加
    1）翻转链表然后再进行翻转
 */
public class offer_025 {

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 得到两者的翻转
        ListNode l1Reverse = reverse(l1);
        ListNode l2Reverse = reverse(l2);

        int plus = 0;
        ListNode pre = null;
        while (l1Reverse != null && l2Reverse != null) {
            // 得到不同的
            int curValue = l1Reverse.val + l2Reverse.val + plus;
            plus = curValue / 10;
            ListNode curNode = new ListNode(curValue % 10);
            curNode.next = pre;
            pre = curNode;
            l1Reverse = l1Reverse.next;
            l2Reverse = l2Reverse.next;
        }

        while (l1Reverse != null) {
            // 根据值进行相加
            int curValue = l1Reverse.val + plus;
            System.out.println("l1 val: " + l1Reverse + "，curvalue：" + curValue);
            plus = curValue / 10;
            ListNode curNode = new ListNode(curValue % 10);
            curNode.next = pre;
            pre = curNode;
            l1Reverse = l1Reverse.next;
        }

        // 将数组进行翻转
        while (l2Reverse != null) {
            // 根据值进行相加
            int curValue = l2Reverse.val + plus;
            plus = curValue / 10;
            ListNode curNode = new ListNode(curValue % 10);
            curNode.next = pre;
            pre = curNode;
            l2Reverse = l2Reverse.next;
        }

        if (plus != 0) {
            ListNode curNode = new ListNode(plus);
            curNode.next = pre;
            pre = curNode;
        }
        return pre;
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
