//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
//
// [["a","b","c","e"], 
//["s","f","c","s"], 
//["a","d","e","e"]] 
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
//
// 
//
// 示例 1： 
//
// 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "A
//BCCED"
//输出：true
// 
//
// 示例 2： 
//
// 输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 168 👎 0


package editor.cn.JianZhiOffer;
//Java：矩阵中的路径
public class POffer12JuZhenZhongDeLuJingLcof{
    public static void main(String[] args) {
        Solution solution = new POffer12JuZhenZhongDeLuJingLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] xy = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        public boolean exist(char[][] board, String word) {
            int row = board.length;
            if (row == 0) return false;
            int col = board[0].length;
            if (word.length() > row * col) return false;
            int len = word.length();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (backTrack(i, j, board, word, 0))
                        return true;
                }
            }
            return false;
        }

        public boolean backTrack(int i, int j, char[][] board, String word, int index) {
            if (i >= board.length || i < 0 || j < 0 || j >= board[0].length || index >= word.length() || word.charAt(index) != board[i][j])
                return false;
            if (index == word.length() - 1) return true;
            char c = board[i][j];
            board[i][j] = '*';
            boolean ret = false;
            for (int k = 0; k < 4; k++) {
                int nexti = i + xy[k][0];
                int nexty = j + xy[k][1];
                if (!ret) {
                    ret = backTrack(nexti, nexty, board, word, index + 1);
                }
                else
                    break;
            }
            board[i][j] = c;
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}