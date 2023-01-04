package leetcode.offer.J二叉树.c前序遍历;

import java.util.HashMap;
import java.util.Map;

public class leetcode_050 {
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

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> preSumCount = new HashMap<>();
        preSumCount.put(0L, 1);
        return dfs(root, preSumCount, targetSum, 0L);
    }


    public int dfs(TreeNode root, Map<Long, Integer> preSumCount, int targetSum, long curSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        // 前序遍历位置
        curSum += root.val;

        res += preSumCount.getOrDefault(curSum - targetSum, 0);
        preSumCount.put(curSum, preSumCount.getOrDefault(curSum, 0) + 1);

        res += dfs(root.left, preSumCount, targetSum, curSum);
        res += dfs(root.right, preSumCount, targetSum, curSum);


        preSumCount.put(curSum, preSumCount.get(curSum) - 1);
        return res;
    }
}
