package 题库.graph.dijkstra;

import java.util.*;

/*
    1) Dijkstra
    2) dp
 */
public class leetcode_787 {


    // n 是节点个数 flights 是飞行 from to weight src(出发点) dst(目标点) k是最长路径
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : flights) {
            int from = edge[0];
            int to = edge[1];
            int price = edge[2];
            graph[from].add(new int[]{to, price});
        }

        // 启动 dijkstra 算法
        // 计算以 src 为起点在 k 次中转到达 dst 的最短路径
        K++;
        return dijkstra(graph, src, K, dst);
    }


    class State {
        // 图节点的 id
        int id;

        // 从 src 节点到当前节点的花费
        int costFromSrc;

        // 从 src 节点到当前节点经过的节点个数
        int nodeNumFromSrc;


        State(int id, int costFromSrc, int nodeNumFromSrc) {
            this.id = id;
            this.costFromSrc = costFromSrc;
            this.nodeNumFromSrc = nodeNumFromSrc;
        }
    }

    // 输入一个起点 start，计算从 start 到其他节点的最短距离
    int dijkstra(List<int[]>[] graph, int src, int k, int dst) {

        // 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
        int[] distTo = new int[graph.length];
        // 定义：从起点 src 到达节点 i 至少要经过 nodeNumTo[i] 个节点
        int[] nodeNumTo = new int[graph.length];

        Arrays.fill(distTo, Integer.MAX_VALUE);
        Arrays.fill(nodeNumTo, Integer.MAX_VALUE);

        // base case，start 到 start 的最短距离就是 0
        distTo[src] = 0;
        nodeNumTo[src] = 0;
        // 优先级队列，distFromStart 较小的排在前面 小根堆
        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            // 根据最小的花费来排序
            return a.costFromSrc - b.costFromSrc;
        });        // 从起点 src 开始进行 BFS
        pq.offer(new State(src, 0, 0));


        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            // 从src到dsc的最短路径
            int costFromSrc = curState.costFromSrc;
            int curNodeNumFromSrc = curState.nodeNumFromSrc;

            //如果当前节点等于
            if (curNodeID == dst) {
                return costFromSrc;
            }

            if (curNodeNumFromSrc == k) {
                // 中转次数耗尽
                continue;
            }

            // 将 curNode 的相邻节点装入队列
            for (int[] neighbor : graph[curNodeID]) {
                int nextNodeID = neighbor[0];
                int costToNextNode = costFromSrc + neighbor[1];
                // 中转次数消耗 1
                int nextNodeNumFromSrc = curNodeNumFromSrc + 1;

                // 更新 dp table
                if (distTo[nextNodeID] > costToNextNode) {
                    distTo[nextNodeID] = costToNextNode;
                    nodeNumTo[nextNodeID] = nextNodeNumFromSrc;
                }
                // 剪枝，如果中转次数更多，花费还更大，那必然不会是最短路径
                if (costToNextNode > distTo[nextNodeID]
                        && nextNodeNumFromSrc > nodeNumTo[nextNodeID]) {
                    continue;
                }

                pq.offer(new State(nextNodeID, costToNextNode, nextNodeNumFromSrc));
            }
        }
        // 在到达某个点的时候已经返回，这里直接返回-1 即可
        return -1;
    }


}