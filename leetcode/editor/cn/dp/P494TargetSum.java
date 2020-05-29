//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 示例 1: 
//
// 输入: nums: [1, 1, 1, 1, 1], S: 3
//输出: 5
//解释: 
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 注意: 
//
// 
// 数组非空，且长度不会超过20。 
// 初始的数组的和不会超过1000。 
// 保证返回的最终结果能被32位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划


package editor.cn.dp;

//Java：目标和
//Date 2020年5月29日
public class P494TargetSum {
    public static void main(String[] args) {
        Solution solution = new P494TargetSum().new Solution();
        // TO TEST
        System.out.println(solution.findTargetSumWays(new int[]{1,1,1,1,1},3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            //如果所有数的和小于目标值，则无法达到返回0
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum < Math.abs(S))
                return 0;

            // 定义dp含义i表示nums{0...i}中的数，组合成j的方法数
            // 由于可以选择减法，组合范围为-sum,+sum，而下标没有负数，则用j=sum时的下标表示和为0,那么j=0表示和为-sum，最终结果为sum+s
            int[][] dp = new int[nums.length][2 * sum + 1];
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] += 1;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < 2 * sum + 1; j++) {
                    dp[i][j] = dp[i - 1][j - nums[i] > 0 ? j - nums[i] : 0] + dp[i - 1][j + nums[i] < 2 * sum + 1 ? j + nums[i] : 0];
                }
            }
            return dp[nums.length - 1][sum + S];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}