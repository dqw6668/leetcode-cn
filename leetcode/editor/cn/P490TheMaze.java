//由空地和墙组成的迷宫中有一个球。球可以向上下左右四个方向滚动，但在遇到墙壁前不会停止滚动。当球停下时，可以选择下一个方向。 
//
// 给定球的起始位置，目的地和迷宫，判断球能否在目的地停下。 
//
// 迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。起始位置和目的地的坐标通过行号和列号给出。 
//
// 
//
// 示例 1: 
//
// 输入 1: 迷宫由以下二维数组表示
//
//0 0 1 0 0
//0 0 0 0 0
//0 0 0 1 0
//1 1 0 1 1
//0 0 0 0 0
//
//输入 2: 起始位置坐标 (rowStart, colStart) = (0, 4)
//输入 3: 目的地坐标 (rowDest, colDest) = (4, 4)
//
//输出: true
//
//解析: 一个可能的路径是 : 左 -> 下 -> 左 -> 下 -> 右 -> 下 -> 右。
//
// 
//
// 示例 2: 
//
// 输入 1: 迷宫由以下二维数组表示
//
//0 0 1 0 0
//0 0 0 0 0
//0 0 0 1 0
//1 1 0 1 1
//0 0 0 0 0
//
//输入 2: 起始位置坐标 (rowStart, colStart) = (0, 4)
//输入 3: 目的地坐标 (rowDest, colDest) = (3, 2)
//
//输出: false
//
//解析: 没有能够使球停在目的地的路径。
//
// 
//
// 
//
// 注意: 
//
// 
// 迷宫中只有一个球和一个目的地。 
// 球和目的地都在空地上，且初始时它们不在同一位置。 
// 给定的迷宫不包括边界 (如图中的红色矩形), 但你可以假设迷宫的边缘都是墙壁。 
// 迷宫至少包括2块空地，行数和列数均不超过100。 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 53 👎 0


package editor.cn;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

//Java：迷宫
public class P490TheMaze{
    public static void main(String[] args) {
        Solution solution = new P490TheMaze().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            // bfs
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[maze.length][maze[0].length];
            queue.add(start);
            visited[start[0]][start[1]] = true;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = cur[0] + dx[i];
                    int nextY = cur[1] + dy[i];
                    while (nextX >= 0 && nextY >= 0 && nextX < maze.length && nextY < maze[0].length && maze[nextX][nextY] == 0) {
                        nextX += dx[i];
                        nextY += dy[i];
                    }
                    nextX -= dx[i];
                    nextY -= dy[i];
                    if (nextX == destination[0] && nextY == destination[1])
                        return true;
                    int[] next = new int[]{nextX, nextY};
                    if (!visited[next[0]][next[1]]) {
                        queue.add(next);
                        visited[next[0]][next[1]] = true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}