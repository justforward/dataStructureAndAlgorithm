package 题库.niuke.A链表;

import java.util.ArrayList;

/**
 * @author tandi
 * @date 2023/3/18 下午3:27
 */
public class BM45 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        // 归并？
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                pre.next = list2;
                list2 = list2.next;
            } else {
                pre.next = list1;
                list1 = list1.next;
            }
            pre = pre.next;
        }

        if (list1 != null) {
            pre.next = list1;
        }
        if (list2 != null) {
            pre.next = list2;
        }
        return dummy.next;
    }


    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() < 0) {
            return null;
        }
        return merge(lists, 0, lists.size() - 1);
    }

    // 这里得到的是切分到最小的链表，只剩下两个链表进行合并
    public ListNode merge(ArrayList<ListNode> list, int left, int right) {
        if (left >= right) {
            return list.get(left);
        }
        int mid = left + (right - left) / 2;
        return MergeSort(merge(list, left, mid), merge(list, mid + 1, right));
    }

    public ListNode MergeSort(ListNode list1, ListNode list2) {
        // 归并？
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                pre.next = list2;
                list2 = list2.next;
            } else {
                pre.next = list1;
                list1 = list1.next;
            }
            pre = pre.next;
        }

        if (list1 != null) {
            pre.next = list1;
        }
        if (list2 != null) {
            pre.next = list2;
        }
        return dummy.next;
    }


    public ListNode sortList(ListNode head) {
        // 链表排序
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        // 一直切到只剩下两个节点的时候开始合并
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
