//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 769 👎 0


package editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//Java：岛屿数量
public class P200NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int row = grid.length;
            if (row == 0) return 0;
            int col = grid[0].length;
            int[][] xy = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
            Deque<int[]> queue = new ArrayDeque<>();
            int res = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        res++;
                        queue.add(new int[]{i,j});
                        grid[i][j] = '0';
                        while (!queue.isEmpty()) {
                            int[] a = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int nextI = xy[k][0] + a[0];
                                int nextJ = xy[k][1] + a[1];
                                if (nextI >= 0 && nextI < row && nextJ >= 0 && nextJ < col && grid[nextI][nextJ] == '1') {
                                    queue.add(new int[]{nextI, nextJ});
                                    grid[nextI][nextJ] = '0';
                                }
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}