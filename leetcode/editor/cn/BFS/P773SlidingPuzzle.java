//在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示. 
//
// 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换. 
//
// 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。 
//
// 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。 
//
// 示例： 
//
// 
//输入：board = [[1,2,3],[4,0,5]]
//输出：1
//解释：交换 0 和 5 ，1 步完成
// 
//
// 
//输入：board = [[1,2,3],[5,4,0]]
//输出：-1
//解释：没有办法完成谜板
// 
//
// 
//输入：board = [[4,1,2],[5,0,3]]
//输出：5
//解释：
//最少完成谜板的最少移动次数是 5 ，
//一种移动路径:
//尚未移动: [[4,1,2],[5,0,3]]
//移动 1 次: [[4,1,2],[0,5,3]]
//移动 2 次: [[0,1,2],[4,5,3]]
//移动 3 次: [[1,0,2],[4,5,3]]
//移动 4 次: [[1,2,0],[4,5,3]]
//移动 5 次: [[1,2,3],[4,5,0]]
// 
//
// 
//输入：board = [[3,2,4],[1,5,0]]
//输出：14
// 
//
// 提示： 
//
// 
// board 是一个如上所述的 2 x 3 的数组. 
// board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列. 
// 
// Related Topics 广度优先搜索 
// 👍 81 👎 0


package editor.cn.BFS;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

//Java：滑动谜题
public class P773SlidingPuzzle{
    public static void main(String[] args) {
        Solution solution = new P773SlidingPuzzle().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] exchangeArray = new int[][]{
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4},
                {1, 3, 5},
                {2, 4}
        };
        // 交换字符
        public String exchangeString(String string, int src, int dis) {
            char[] chars = string.toCharArray();
            char temp = chars[dis];
            chars[dis] = chars[src];
            chars[src] = temp;
            return new String(chars);
        }
    public int slidingPuzzle(int[][] board) {
        char[] chars = new char[6];
        int index = 0;
        for (int[] row:board) {
            for (int ch:row) {
                chars[index++] = (char)(ch+'0');
            }
        }
        String start = new String(chars);
        String target = "123450";
        // BFS套路
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.offer(start);
        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                if (cur.equals(target))
                    return step;
                int position = cur.indexOf('0');
                int[] exchanges = exchangeArray[position];
                for (int exchange : exchanges) {
                    String s = exchangeString(cur, exchange, position);
                    if (!visited.contains(s)) {
                        q.add(s);
                        visited.add(s);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}