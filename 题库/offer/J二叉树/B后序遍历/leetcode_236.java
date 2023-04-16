package 题库.offer.J二叉树.B后序遍历;

/**
 * @author tandi
 * @date 2023/3/18 下午1:47
 */
public class leetcode_236 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            // 如果找到这两个节点
            return root;
        }
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor1(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor1(root.right, p, q);
        return root;
    }

}
