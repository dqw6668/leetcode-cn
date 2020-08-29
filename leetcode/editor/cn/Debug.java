package editor.cn;

import java.util.*;

/**
 * Created by Five on 2020/8/27 19:04
 */
public class Debug {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasPath(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}
                , new int[]{0, 4}
                , new int[]{3, 2}));
    }
}
class Solution {
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        // bfs
        Queue<int[]> queue = new ArrayDeque<>();
        Map<Integer, Integer> visited = new HashMap<>();
        queue.add(new int[]{start[0], start[1]});
        visited.put(new Integer(start[0]), new Integer(start[1]));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0], nextY = cur[1];
                while (dx[i]!= 0 && nextX >= 0 && nextX < maze.length && maze[nextX][nextY] == 0) {
                    nextX += dx[i];
                }
                nextX -= dx[i];
                while (dy[i]!= 0 && nextY >= 0 && nextY < maze[0].length && maze[nextX][nextY] == 0) {
                    nextY += dy[i];
                }
                nextY -= dy[i];
                int[] next = new int[]{nextX, nextY};
                if (nextX >= 0 && nextX < maze.length && nextY >= 0 && nextY < maze[0].length && !(visited.containsKey(nextX) && visited.get(nextX) == nextY) && maze[nextX][nextY] == 0) {
                    if (nextX == destination[0] && nextY == destination[1])
                        return true;
                    queue.add(next);
                    visited.put(new Integer(nextX), new Integer(nextY));
                }
            }
        }
        return false;
    }
}
