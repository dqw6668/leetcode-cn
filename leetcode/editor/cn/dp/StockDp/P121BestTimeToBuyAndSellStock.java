//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。 
//
// 注意：你不能在买入股票前卖出股票。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 5
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
// Related Topics 数组 动态规划


package editor.cn.dp.StockDp;

//Java：买卖股票的最佳时机
public class P121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new P121BestTimeToBuyAndSellStock().new Solution();
        // TO TEST
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(solution.maxProfit(new int[]{1,1,1,1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            // 特判
            if (len < 2)
                return 0;
            // 定义dp[i][j]表示在第i天 1持有 或者 0不持有 股票时的最大利润
            int[][] dp = new int[len + 1][2];
            // base状态 第一天
            dp[1][0] = 0;
            dp[1][1] = -prices[0];
            for (int i = 2; i <= len; i++) {
                // 当天没有股票可能来自于 头一天没持有 或者 头一天持有但卖出了
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
                // 当天持有股票来自于 头一天就持有 或者头一天没有但是买入 由于只能买卖一次，所以之前的利润都为0
                dp[i][1] = Math.max(dp[i - 1][1], - prices[i - 1]);
            }
            return dp[len][0];
        }
    }

    // 空间上优化
    class Solution2 {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            // 特判
            if (len < 2)
                return 0;
            // 表示在第i天没持有股票的最大利润 初始为第一天的base状态
            int dp_i_0 = 0;
            // 表示在第i天持有股票的最大利润 初始为第一天的base状态
            int dp_i_1 = -prices[0];
            for (int i = 1; i < len; i++) {
                // 当天没有股票可能来自于 头一天没持有 或者 头一天持有但卖出了
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                // 当天持有股票来自于 头一天就持有 或者头一天没有但是买入 由于只能买卖一次，所以之前的利润都为0
                dp_i_1 = Math.max(dp_i_1, -prices[i]);
            }
            return dp_i_0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}