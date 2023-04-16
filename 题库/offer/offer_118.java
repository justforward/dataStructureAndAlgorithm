package 题库.offer;

/*
    树可以看成是一个连通且 无环 的 无向 图。

    思路一：
   1、构建图
   2、从顶点 1开始遍历 如果出现 回来的值，直接进行删除操作 深度优先遍历
   思路二：
   1、并查集
   将1—>2 2->3 3->4 直接合并为1-4



 */
public class offer_118 {

    public int[] findRedundantConnection(int[][] edges) {
        //因为是在树的基础上加了一条边，所以edges的长度就是点的数量
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            if (!uf.connected(from, to)) {
                uf.union(from, to);
            } else {
                return new int[]{from, to};
            }
        }
        return new int[]{};
    }


    class UnionFind {
        // 连通分量个数
        private int count;
        // 存储一棵树
        private int[] parent;
        // 记录树的“重量”
        private int[] size;

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ)
                return;

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        private int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        /* 返回当前的连通分量个数 */
        public int count() {
            return count;
        }
    }

}
