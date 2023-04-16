package 题库.interview;

import java.util.HashMap;
import java.util.Map;

/*
    前缀和：root到当前节点的和

    在同一个路径之下（可以理解成二叉树从root节点出发，到叶子节点的某一条路径），
    如果两个数的前缀总和是相同的，那么这些节点之间的元素总和为零。
        进一步扩展相同的想法，如果前缀总和currSum，在节点A和节点B处相差target，则位于节点A和节点B之间的元素之和是target。

       路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)

    ps：不一定非到叶子节点结束

 */
public class i_04_12 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }




    /*
        从根节点到当前节点的所有路径和，保留这个前缀和
     */
    public int pathSum1(TreeNode root, int sum) {
        // key是前缀和, value是大小为key的前缀和出现的次数
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        prefix.put(0L, 1);
        //当前和记录下来
        return recursionPathSum(root, prefix, sum, 0);
    }


    private int recursionPathSum(TreeNode node, Map<Long, Integer> prefixSumCount, int target, long currSum) {
        // 1.递归终止条件
        if (node == null) {
            return 0;
        }
        // 2.本层要做的事情
        int res = 0;
        // 当前路径上的和
        currSum += node.val;

        //---核心代码
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        res += prefixSumCount.getOrDefault(currSum - target, 0);
        // 更新路径上当前节点前缀和的个数
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        //---核心代码

        // 3.进入下一层
        res += recursionPathSum(node.left, prefixSumCount, target, currSum);
        res += recursionPathSum(node.right, prefixSumCount, target, currSum);

        // 4.回到本层，恢复状态，去除当前节点的前缀和数量
        // 后序遍历 是需要回到本层上 所以需要-1
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
        return res;
    }



    // 两层递归实现
    int ans = 0;

    public int pathSum(TreeNode root, int sum) {
        preOrder(root, sum);
        return ans;
    }

    public void preOrder(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        dfs(root, sum);
        preOrder(root.left, sum);
        preOrder(root.right, sum);
    }

    // 从根节点开始和为某个数的路径
    //
    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            ans++;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }


}
