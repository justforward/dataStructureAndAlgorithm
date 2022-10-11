package leetcode.interview;

/*
    题目：
        1）图中可能存在自环和平行边

    知识点：构建图和图遍历
    1）build  adjacency List(邻接表)

   邻接表，如何规避环？DFS深度遍历，通过visit set来规避环

 */

import java.util.*;


public class i_04_01 {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        HashMap<Integer, List<Integer>> adjListMap = new HashMap<>();
        for (int[] g : graph) {
            if (!adjListMap.containsKey(g[0])) {
                adjListMap.put(g[0], new ArrayList<>());
            }
            adjListMap.get(g[0]).add(g[1]);
        }
        return dfs(adjListMap, start, target, new HashSet<Integer>());
    }

    public boolean dfs(HashMap<Integer, List<Integer>> graph, int start, int target, HashSet<Integer> visited) {
        List<Integer> neighbor = graph.get(start);
        if (neighbor == null) {
            return false;
        }
        for (int n : neighbor) {
            if (n == target) {
                return true;
            }
            if (visited.contains(n)) {
                continue;
            }
            visited.add(n);
            if (dfs(graph, n, target, visited)) {
                return true;
            }
            visited.remove(n);
        }
        return false;
    }
}
