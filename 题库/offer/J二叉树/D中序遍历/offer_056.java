package 题库.offer.J二叉树.D中序遍历;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class offer_056 {
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

    List<Integer> ans = new LinkedList<>();

    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : ans) {
            if (map.containsKey(k - i)) {
                return true;
            }
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return false;
    }


    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }


}
