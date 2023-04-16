package 题库.offer.J二叉树.A层次遍历;

import java.util.LinkedList;
import java.util.Queue;

public class offer_043 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class CBTInserter {
        Queue<TreeNode> queue;
        TreeNode root;

        public CBTInserter(TreeNode root) {
            this.queue = new LinkedList<>();
            this.root = root;

            // queue 只存储左节点或者右节点不存在的节点
            Queue<TreeNode> all = new LinkedList<>();
            TreeNode head = root;
            all.add(head);
            while (!all.isEmpty()) {
                TreeNode poll = all.poll();
                if (poll.left != null) all.offer(poll.left);
                if (poll.right != null) all.offer(poll.right);
                // 如果一个节点的左节点不存在或者右节点不存在节点，那么说明这个值需要
                if (poll.left == null || poll.right == null) queue.add(poll);
            }

        }

        // 返回父节点的值
        public int insert(int v) {
            TreeNode peek = queue.peek();
            TreeNode inNode = new TreeNode(v);
            int val = peek.val;
            if (peek.left == null) {
                peek.left = inNode;
            } else {
                peek.right = inNode;
                // 父节点已经是左右子节点都存在的，直接从队列中弹出
                queue.poll();
            }
            this.queue.add(inNode);

            return val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

}
