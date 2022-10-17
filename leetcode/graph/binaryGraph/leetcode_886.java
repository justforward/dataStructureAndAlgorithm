package leetcode.graph.binaryGraph;

import java.util.ArrayList;

/*
    思路：
        根据关系构建图，边链接的节点染色不能一样。
 */
public class leetcode_886 {
    public static boolean ok = true;
    boolean[] colors;
    boolean[] visited;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        colors = new boolean[n + 1];
        visited = new boolean[n + 1];
        // 根据dislike 构建图
        ArrayList<Integer>[] graph = buildGraph(n, dislikes);
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(graph, i);
            }
        }
        return ok;
    }

    public void dfs(ArrayList<Integer>[] graph, int v) {
        // v是当前遍历的节点
        // 如果已经判断这个图不是二分图 那么直接返回
        if (!ok) return;

        visited[v] = true;

        // 得到当前节点的邻居节点
        for (int n : graph[v]) {
            // 如果这个邻居点没有被访问过，将这个节点置为和当前节点染色相反的
            if (!visited[n]) {
                // 将 邻居的节点全部 染成和当前相反的节点
                colors[n] = !colors[v];
                // 继续从当前节点遍历
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


    public ArrayList<Integer>[] buildGraph(int n, int[][] fromTo) {
        ArrayList<Integer>[] res = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = new ArrayList<>();
        }
        for (int[] edge : fromTo) {
            int from = edge[0];
            int to = edge[1];
            // 构建无向图 from -> to
            // to -> from
            res[from].add(to);
            res[to].add(from);
        }
        return res;
    }

}
