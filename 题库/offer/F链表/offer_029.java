package 题库.offer.F链表;

/*
    题目：
    给定循环单调非递减列表中的一个点， 插入这个点之后，依旧是单调递增的

    思路：
    1)找到链表中真正的最小节点和最大节点
    2)从最小节点开始遍历，找到适合插入的条件。
        注意有的值比所有的节点都小或者大 此时需要将这个值插入到对应的位置，


 */
public class offer_029 {

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    ;


    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node cur = new Node(insertVal);
            cur.next = cur;
            return cur;
        }

        Node roll = head.next;
        Node maxNode = head;
        while (roll != head) {
            if (roll.val > maxNode.val) {
                maxNode = roll;
            }
            roll = roll.next;
        }

        Node minNode = maxNode.next;
        Node insertNode = new Node(insertVal);
        // 如果当前值小于等于最小值
        // 或者当前值大于最大值
        if (insertVal <= minNode.val || insertVal >= maxNode.val) {
            insertNode.next = minNode;
            maxNode.next = insertNode;
            return head;
        }

        while (minNode != maxNode) {
            Node next = minNode.next;
            if (insertVal >= minNode.val && insertVal < next.val) {
                minNode.next = insertNode;
                insertNode.next = next;
            }
            minNode = next;
        }

        return head;

    }
}
