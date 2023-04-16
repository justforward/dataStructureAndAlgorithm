package 题库.day;


/*
    前缀树+贪心
 */
public class leetcode_421 {

    public static int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            trie.add(nums[i]);
            // 从树中找到与当前值的最大异或值
            ans = Math.max(ans, trie.findMax(nums[i]));
        }
        return ans;
    }

    static class Trie {

        // 前缀树两个节点，一个是1 一个是0
        Trie[] next;

        public Trie() {
            this.next = new Trie[2];
        }

        // 往前缀树上添加元素
        public void add(int num) {
            Trie root = this;

            // 保留31位的前缀树
            for (int i = 30; i >= 0; i--) {
                // 得到最高位的状态 &1 检查当前位，返回当前数的本身
                int index = num >> i & 1;

                /*
                    检查下一层是否存在，不存在的时候new
                 */
                if (root.next[index] == null) {
                    root.next[index] = new Trie();
                }
                root = root.next[index];
            }
        }

        // 查找前缀树与当前值异或最大值
        public int findMax(int num) {
            Trie root = this;
            int res = 0;
            for (int i = 30; i >= 0; i--) {
                int index = num >> i & 1;

                // 得到当前index的期望值
                index ^= 1;

                if (root.next[index] != null) {
                    res |= (1 << i);
                } else {
                    // 说明没有期望的结果，走另一条路
                    index ^= 1;
                }
                root = root.next[index];
            }

            return res;
        }


    }

}
