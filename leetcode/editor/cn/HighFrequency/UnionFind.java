package editor.cn.HighFrequency;

import java.util.Arrays;

/**
 * Created by Five on 2020/9/6 23:29
 */
public class UnionFind {
    class Solution {
        // 并查集
        // 记录某条边是否已经用过在图中
        private boolean[] used;
        public int maxNumEdgesToRemove(int n, int[][] edges) {
            used = new boolean[edges.length];
            Arrays.sort(edges, (o1, o2) -> o2[0] - o1[0]);
            // !=1 意味着有多个老大，那么图不连通
            if (unionFind(n, edges, 1) != 1) return -1;
            if (unionFind(n, edges, 2) != 1) return -1;
            // 构建好帮派后，看看有没用到的边，就是可以去除的
            int res = 0;
            for (int i = 0; i < used.length; i++) {
                if (used[i] == false)
                    res++;
            }
            return res;
        }

        //对n个节点使用edges中的边构建帮派，返回帮派的个数
        private int unionFind(int n, int[][] edges, int excludeType) {
            int[] union = new int[n + 1];
            // 最开始每个人自成一派
            for (int i = 0; i < n; i++)
                union[i] = i;
            // 对于每一条边，画边
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                if (excludeType == edge[0])
                    continue;
                // 分别找到ui, vi的老大，不是同一个帮派，给他们画边，边就用过了，已经一个帮派则不管
                int root1 = findRoot(union, edge[1]);
                int root2 = findRoot(union, edge[2]);
                if (root1 != root2) {
                    union[root1] = root2;
                    used[i] = true;
                }
            }
            // 数帮派个数
            int ret = 0;
            for (int i = 0; i <= n; i++) {
                if (union[i] == i)
                    ret++;
            }
            return ret;
        }

        private int findRoot(int[] union, int child) {
            if (union[child] != child) {
                int root = findRoot(union, union[child]);
                // 路径压缩，直接放到老大下面
                union[child] = root;
                return root;
            }
            return child;
        }
    }
}
