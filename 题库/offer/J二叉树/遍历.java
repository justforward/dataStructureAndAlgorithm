package 题库.offer.J二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author tandi
 * @date 2023/3/18 上午10:18
 */
public class 遍历 {

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

    // 前中后的非递归遍历

    // 前序遍历
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.add(cur.val);
            if (cur.right != null) {
                stack.add(cur.left);
            }
            if (cur.left != null) {
                stack.add(cur.right);
            }
        }

        return ans;

    }

    //中序遍历
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) { // 指针来访问节点，访问到最底层
                stack.add(root); // 将访问的节点放入栈中
                root = root.left;// 继续一直走到底
            } else {
                TreeNode cur = stack.pop();
                ans.add(cur.val);
                root = root.right;
            }
        }
        return ans;
    }

    // 后序遍历顺序是：左右中
    // 入栈顺序是：中左右 出栈顺序是中右左 然后翻转

    public List<Integer> postOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root); // 这个代表中间的节点
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.add(cur.val);
            if (cur.left != null) {
                stack.add(root.left);
            }
            if (cur.right != null) {
                stack.add(root.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }


    // 层次遍历

    public List<List<Integer>> order(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode poll = queue.poll();
                tmp.add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            ans.add(tmp);
        }
        return ans;
    }
}
