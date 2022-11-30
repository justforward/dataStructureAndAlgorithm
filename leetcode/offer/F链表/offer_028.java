package leetcode.offer.F链表;

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
            Node dummy;
            while (head != null) {
                Node next = head.next;
                Node child = head.child;
                // 得到文件的子节点
                // 得到
                while (child != null) {

                }
            }
        }
    }
}
