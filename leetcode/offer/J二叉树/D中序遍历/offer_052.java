package leetcode.offer.J二叉树.D中序遍历;

public class offer_052 {
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

    public TreeNode increasingBST(TreeNode root) {
        // 中序遍历

        return root;

    }

    public TreeNode inOrder(TreeNode root) {
        return root;
    }
}
