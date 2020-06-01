//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法


package editor.cn.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：N皇后
// Date 2020年6月1日
public class P51NQueens {
    public static void main(String[] args) {
        Solution solution = new P51NQueens().new Solution();
        // TO TEST
        System.out.println(solution.solveNQueens(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 题目需要返回的res
        List<List<String>> res = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            // 特判
            if (n < 1) return res;
            // 该list中的每一个int表示，每一行的第i列放皇后,一个queen表示一种棋盘解
            List<Integer> queen = new LinkedList<>();
            // 从第0行开始寻求解,一行一行的往下放
            backtrack(0, n, queen);
            return res;
        }

        /**
         * @param index 表示当前选择的行
         * @param n
         * @param queen 当前已经摆放好的棋盘
         */
        public void backtrack(int index, int n, List<Integer> queen) {
            // 写递归，先写终止条件
            if (index == n) {
                List<String> tmp = new ArrayList<>();
                for (Integer i : queen) {
                    char[] row = new char[n];
                    Arrays.fill(row, '.');
                    row[i] = 'Q';
                    tmp.add(new String(row));
                }
                res.add(tmp);
                return;
            }
            // 做选择,对当前行的每一列进行尝试放皇后
            for (int col = 0; col < n; col++) {
                // 判断每一列上放的皇后
                if (!queen.contains(col)) {
                    // 判断两个对角线
                    if (!isDiagonalAttack(queen, col)) {
                        // 把当前列也放入棋盘
                        queen.add(col);
                        // 递归
                        backtrack(index + 1, n, queen);
                        // 回溯
                        queen.remove(queen.size() - 1);
                    }
                }
            }
        }

        private boolean isDiagonalAttack(List<Integer> currentQueen, int i) {
            int currentRow = currentQueen.size();
            int currentCol = i;
            //判断每一行的皇后的情况
            for (int row = 0; row < currentQueen.size(); row++) {
                //左上角的对角线和右上角的对角线，两点间构成的斜率应该为45°
                if (Math.abs(currentRow - row) == Math.abs(currentCol - currentQueen.get(row))) {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}