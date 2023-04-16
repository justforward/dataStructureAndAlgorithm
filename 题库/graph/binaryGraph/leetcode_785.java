package 题库.graph.binaryGraph;

/*
    题目 给定的是邻接表，直接进行使用

    染色的过程：一边遍历 一边进行染色 然后 实现图的遍历过程

 */
public class leetcode_785 {

    public static boolean ok = true;
    boolean[] visited;
    boolean[] colors; // true 和false 代表两种不同的颜色

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        colors = new boolean[n];
        visited = new boolean[n];

        // 遍历图 从每个节点开始遍历? 为什么从每个节点开始
        // 因为图不一定是联通的，可能存在多个子图
        // 所以要把每个节点都作为起点进行一次遍历
        // 如果发现任何一个子图不是二分图，整幅图都不算二分图
        for (int i = 0; i < n; i++) {
            // 如果遍历的过程中 没有点的联调
            if (!visited[i]) {
                dfs(graph, i);
            }
        }
        return ok;
    }


    public void dfs(int[][] graph, int v) {
        // v是当前遍历的节点
        // 如果已经判断这个图不是二分图 那么直接返回
        if (!ok) return;

        visited[v] = true;

        // 得到当前节点的邻居节点
        for (int n : graph[v]) {
            // 如果这个点没有被访问过，将这个节点1234
            if (!visited[n]) {
                // 将 邻居的节点全部 染成和当前相反的节点
                colors[n] = !colors[v];
                dfs(graph, n);
            } else {
                // 判断邻居节点和当前节点的颜色是否相等
                if (colors[n] == colors[v]) {
                    ok = false;
                    return;
                }
            }
        }
    }
}
