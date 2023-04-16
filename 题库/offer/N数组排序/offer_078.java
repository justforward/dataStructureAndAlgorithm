package 题库.offer.N数组排序;

/**
 * @author tandi
 * @date 2023/2/25 下午4:06
 */
public class offer_078 {
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


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        return merge(0, lists.length - 1, lists);
    }


    public ListNode merge(int left, int right, ListNode[] lists) {
        if (left >= right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        return sort(merge(left, mid, lists), merge(mid + 1, right, lists));
    }


    public ListNode sort(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val > h2.val) {
                pre.next = h1;
                h1 = h1.next;
            } else {
                pre.next = h2;
                h2 = h2.next;
            }
            pre = pre.next;
        }
        pre.next = h1 != null ? h1 : h2;
        return pre.next;
    }


}
