package leetcode.interview;

/*
    题目：
        给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

        给定有序数组: [-10,-3,0,5,9] 一个可能的答案是：[0,-3,9,-10,null,5]

        思路：有序？二分直接操作，每次选取某个区间内的中间值 构建根节点？

 */


import java.util.Arrays;

public class i_04_02 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 每次找到
    public TreeNode sortedArrayToBST(int[] nums) {
        return DFS(nums, 0, nums.length - 1);
    }


    public TreeNode DFS(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = DFS(nums, left, mid - 1);
        node.right = DFS(nums, mid + 1, right);
        return node;
    }

}
