//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划 
// 👍 535 👎 0


package editor.cn;
//Java：最大正方形
public class P221MaximalSquare{
    public static void main(String[] args) {
        Solution solution = new P221MaximalSquare().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int row = matrix.length;
            if (row == 0) return 0;
            int col = matrix[0].length;
            if (col == 0) return 0;

            // 表示i,j点为正方形右下角点的最大边长
            int[][] dp = new int[row + 1][col + 1];
            for (int i = 0; i < row; i++) {
                if (matrix[i][0] == '1')
                    dp[i][0] = 1;
            }
            for (int i = 0; i < col; i++) {
                if (matrix[0][i] == '1')
                    dp[0][i] = 1;
            }
            int res = dp[0][0];
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = 1;
                        if ((matrix[i - 1][j] == '1') && (matrix[i][j - 1] == '1') && (matrix[i - 1][j - 1] == '1'))
                            dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
            return res * res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}