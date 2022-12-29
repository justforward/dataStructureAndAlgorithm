package leetcode.offer.J二叉树.c前序遍历;

public class offer_049 {
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

    StringBuilder stringBuilder = new StringBuilder();
    int ans = 0;

    public int sumNumbers(TreeNode root) {
        Traverse(root);
        return ans;
    }

    public void Traverse(TreeNode root) {
        if (root == null) return;

        stringBuilder.append(root.val);
        if (root.left == null && root.right == null) {
            ans += Integer.parseInt(stringBuilder.toString());
        }

        Traverse(root.left);
        Traverse(root.right);

        //在后序遍历的位置 撤销节点数
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
}
