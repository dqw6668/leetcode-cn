//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法 
// 👍 469 👎 0


package editor.cn.backtrack;

//Java：解数独
public class P37SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new P37SudokuSolver().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            if (null == board || board.length == 0 || board[0].length == 0)
                return;
            backtrack(board, 0, 0);
        }

        /***
         *
         * @param board
         * @param row 有效值为0-8 表示位置
         * @param col 有效值为0-8
         * @return
         */
        private boolean backtrack(char[][] board, int row, int col) {
            if (row == 9)
                return true;
            // 开始下一行
            if (col == 9)
                return backtrack(board, row + 1, 0);
            for (int i = row; i < 9; i++) {
                for (int j = col; j < 9; j++) {
                    if (board[i][j] != '.') {
                        return backtrack(board, i, j + 1);
                    }
                    for (char c = '1'; c <= '9'; c++) {
                        // 如果不能填这个数
                        if (!isValid(board, i, j, c))
                            continue;
                        // 可以填
                        board[i][j] = c;
                        // 如果能填完就返回
                        if (backtrack(board, i, j + 1))
                            return true;
                        board[i][j] = '.';
                    }
                    // i,j这个位置9个数都填不了
                    return false;
                }
            }
            return false;
        }

        private boolean isValid(char[][] board, int row, int col, char ch) {
            for (int i = 0; i < 9; i++) {
                // 每一行9个
                if (board[row][i] == ch) return false;
                // 每一列9个
                if (board[i][col] == ch) return false;
                // 每个小9格
                if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == ch) return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}