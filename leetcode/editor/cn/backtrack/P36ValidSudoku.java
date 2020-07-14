//判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 
//
// 上图是一个部分填充的有效的数独。 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 示例 1: 
//
// 输入:
//[
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//[
//  ["8","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
//]
//输出: false
//解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
//     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 
//
// 说明: 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 给定数独序列只包含数字 1-9 和字符 '.' 。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 
// 👍 371 👎 0


package editor.cn.backtrack;

//Java：有效的数独
public class P36ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new P36ValidSudoku().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            for (int i = 0; i < 9; i++) {
                // hori, veti, sqre分别表示行、列、小宫
                int hori = 0, veti = 0, sqre = 0;
                for (int j = 0; j < 9; j++) {
                    // 由于传入为char，需要转换为int，减48
                    int h = board[i][j] - 48;
                    int v = board[j][i] - 48;
                    int s = board[3 * (i / 3) + j / 3][3 * (i % 3) + j % 3] - 48;
                    // "."的ASCII码为46，故小于0代表着当前符号位"."，不用讨论
                    if (h > 0) {
                        hori = ((hori >> h) & 1) == 1 ? -1 : hori ^ (1 << h);
                        if (hori == -1)
                            return false;
                    }
                    if (v > 0) {
                        veti = ((veti >> v) & 1) == 1 ? -1 : veti ^ (1 << v);
                        if (veti == -1)
                            return false;
                    }
                    if (s > 0) {
                        sqre = ((sqre >> s) & 1) == 1 ? -1 : sqre ^ (1 << s);
                        if (sqre == -1)
                            return false;
                    }
                }
            }
            return true;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Solution2 {
        public boolean isValidSudoku(char[][] board) {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    char curNum = board[row][col];
                    if (curNum == '.')
                        continue;
                    for (int i = 0; i < 9; i++) {
                        if (i != col && board[row][i] == curNum)
                            return false;
                    }
                    for (int i = 0; i < 9; i++) {
                        if (i != row && board[i][col] == curNum)
                            return false;
                    }
                    for (int i = 0, tmpRow = (row / 3 * 3); i < 3; i++) {
                        for (int j = 0, tmpCol = (col / 3 * 3); j < 3; j++) {
                            if (board[tmpRow][tmpCol] == curNum && row != tmpRow && col != tmpCol)
                                return false;
                            tmpCol++;
                        }
                        tmpRow++;
                    }
                }
            }
            return true;
        }
    }
}