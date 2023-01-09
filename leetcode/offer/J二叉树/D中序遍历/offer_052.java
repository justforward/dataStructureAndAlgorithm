package leetcode.offer.J二叉树.D中序遍历;

import java.util.LinkedList;
import java.util.List;

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

    List<TreeNode> ans = new LinkedList<>();

    public TreeNode increasingBST(TreeNode root) {
        // 中序遍历
        inOrder(root);
        TreeNode dummy = null;
        for (TreeNode an : ans) {
            dummy.right = an;
            dummy = an;
        }

        return dummy.right;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        ans.add(root);
        inOrder(root.right);
    }
}
