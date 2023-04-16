package 题库.tree.binary;


public class i_04_04 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = DFS(root.left);
        int right = DFS(root.right);
        // 还需要查看本身的子树是否 是平衡树
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = DFS(root.left);
        int right = DFS(root.right);
        return Math.max(left, right) + 1;
    }

}
