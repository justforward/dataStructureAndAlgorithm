package leetcode.offer.F链表;

import java.util.HashMap;

/*
    得到两个链表的相交的节点
 */
public class offer_023 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        while (headA != null) {
            hashMap.put(headA, 1);
            headA = headA.next;
        }

        while (headB != null) {
            if (hashMap.containsKey(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;

    }
}
