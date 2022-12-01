package leetcode.offer.F链表;

import java.util.HashMap;
import java.util.Map;

/*
    给定循环单调非递减列表中的一个点， 插入这个点之后，依旧是单调递增的

    【3,4,1】 得到的位置是大于当前节点 小于下一个节点
     【1】 得到的是 插入的是0  得到相遇的点，需要查看这个 元素是否是
      记录这个元素所在环位置
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
        // 循环链表 得到最大值和最小值。根据最大值和最小值进行判断链表的插入



//        if (head == null) {
//            Node cur = new Node(insertVal);
//            cur.next = cur;
//            return cur;
//        }
//
//        Node cur = head;
//        HashMap<Node, Integer> map = new HashMap<>();
//        Node pre = null;
//        while (cur != null) {
//            // 走了一圈之后，还没有找到合适的位置，查看
//            if (map.containsKey(cur)) {
//                // pre是开端
//                //if (pre.val <= cur.val) {
//                Node insertNode = new Node(insertVal);
//                pre.next = insertNode;
//                insertNode.next = cur;
//                //}
//                break;
//            }
//            map.put(cur, 1);
//            // 当前节点小于 这个点，下一个节点不为null 并且这个节点
//            if (cur.val >= insertVal && (pre != null && pre.val <= insertVal)) {
//                Node insertNode = new Node(insertVal);
//                Node next = cur.next;
//                cur.next = insertNode;
//                insertNode.next = next;
//                break;
//            }
//            pre = cur;
//            cur = cur.next;
//        }
//        return head;
    }
}
