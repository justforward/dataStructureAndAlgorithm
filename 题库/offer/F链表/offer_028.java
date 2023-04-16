package 题库.offer.F链表;

public class offer_028 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    class Solution {
        // 展开node 记录next
        public Node flatten(Node head) {
            Node cur = head;
            while (cur != null) {
                // 立即处理head所在的child层
                if (cur.child != null) {
                    // 首先存储的是当前的next，在处理完child所在层之后，就去对这个进行处理
                    Node next = cur.next;
                    // 这个指向child
                    cur.next = cur.child;
                    cur.child.prev = cur;
                    cur.child = null;
                    Node last = cur.next;
                    // 找到本层的最后一个节点
                    while (last.next != null) last = last.next;
                    if (next != null) {
                        last.next = next;
                        next.prev = last;
                    }
                }
                cur = cur.next;

            }
            return head;
        }

    }
}
