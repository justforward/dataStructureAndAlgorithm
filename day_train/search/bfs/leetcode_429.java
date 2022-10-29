package day_train.search.bfs;
/*
    N叉树的层次遍历
 */


import java.util.ArrayList;
import java.util.List;

public class leetcode_429 {


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        return ans;
    }
}
