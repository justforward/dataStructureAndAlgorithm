package 题库.weekend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author tandi
 * @date 2022/11/13 10:38 上午
 */


//Definition for a binary tree node.


public class Solution {
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

    public int minimumOperations(TreeNode root) {
        int ans = 0;
        // 层次遍历 排序
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        //二叉树的层次遍历
        q.add(root);
        while (q.size() != 0) {
            int len = q.size();
            List<Integer> ll = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                ll.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            ans += sort(ll);
            //排序
            list.add(ll);

        }

        return ans;
    }

    public int sort(List<Integer> list) {
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        int[] temp = Arrays.copyOf(nums, nums.length);
        //排序并记录每个数的正确位置
        Arrays.sort(temp);
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            indexMap.put(temp[i], i);
        }
        //记录该位置是否已访问
        boolean[] isVisited = new boolean[temp.length];
        //寻找循环节个数，即循环节内的数依次交换，即可全部回到正确位置
        int loops = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            int j = i;
            while (!isVisited[j]) {
                isVisited[j] = true;
                j = indexMap.get(nums[j]);
            }
            loops++;

        }
        //对每一个循环节来说，交换次数为循环节内元素个数减一
        //举例，若nums存在三个循环节，nums元素个数为n，各循环节元素个数为x, y, z
        //则交换次数应为 (x-1)+(y-1)+(z-1)=x+y+z-3=n-3
        //其他情况以此类推，最小交换次数为数组元素个数-循环节个数
        return nums.length - loops;

    }

}
