package leetcode.interview;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class i_04_03 {

    /*
        思路：层次遍历
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        ArrayList<ListNode> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                cur.next = new ListNode(node.val);
                cur = cur.next;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (cur.next != null) {
                res.add(dummy.next);
            }

        }

        return res.toArray(new ListNode[res.size()]);
    }
}
