//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
//
// 
//
// 
// 
//
// 示例 1: 
//
// 输入: amount = 5, coins = [1, 2, 5]
//输出: 4
//解释: 有四种方式可以凑成总金额:
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2: 
//
// 输入: amount = 3, coins = [2]
//输出: 0
//解释: 只用面额2的硬币不能凑成总金额3。
// 
//
// 示例 3: 
//
// 输入: amount = 10, coins = [10] 
//输出: 1
// 
//
// 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= amount (总金额) <= 5000 
// 1 <= coin (硬币面额) <= 5000 
// 硬币种类不超过 500 种 
// 结果符合 32 位符号整数 
// 
// 👍 206 👎 0


package editor.cn;
//Java：零钱兑换 II
//Date 2020年07月31日 18:43
public class P518CoinChange2{
    public static void main(String[] args) {
        Solution solution = new P518CoinChange2().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        // 定义dp数组 dp[i][j] coins{0...i}中的硬币，组成金额j，能得到的组合数
        int[][] dp = new int[len + 1][amount + 1];
        // base状态
        // 组成金额0的方式均为1种
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }
        // 没有硬币组合为0
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = 0;
        }
        // 填表
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= amount; j++) {
                // 如果要组合的金额大于当前第i个硬币，第i个硬币才能放
                if (j >= coins[i - 1])
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[len][amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}