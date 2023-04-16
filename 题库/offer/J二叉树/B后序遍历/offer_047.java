package 题库.offer.J二叉树.B后序遍历;

public class offer_047 {

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

    /*
        如果左右子树为0的时候，当前节点删除
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.val == 0 && root.right == null && root.left == null) {
            // 返回值会被父节点接收，相当于把自己删掉了
            return null;
        }

        return root;
    }

}
