//有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 
//left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 说明: 
//
// 
// 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。 
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 
// 
//
// 示例: 
//
// 输入: [3,1,5,8]
//输出: 167 
//解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
// 
// Related Topics 分治算法 动态规划


package editor.cn;
//Java：戳气球
public class P312BurstBalloons{
    public static void main(String[] args) {
        Solution solution = new P312BurstBalloons().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCoins(int[] nums) {
            // 特判
            int len = nums.length;
            if (len <= 0) return 0;
            // 狀態 dp 选择 base  dp[][]表示戳i到j内气球的解,不包括i j  ret=dp[0][len+1]
            int[][] dp = new int[len + 2][len + 2];
            // 假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破
            // 转换后i,j表示下标
            int[] dummy = new int[len + 2];
            dummy[0] = dummy[len + 1] = 1;
            for (int i = 0; i < len; i++) {
                dummy[i + 1] = nums[i];
            }
            // base状态初始为0
            // 開始填表
            for (int i = len; i >= 0; i--) {
                for (int j = i + 1; j <= len + 1; j++) {
                    // 取状态k表示最后一个戳破k
                    for (int k = i + 1; k < j; k++) {
                        // 使用转换填充后的dummy
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + dummy[k] * dummy[i] * dummy[j]);
                    }
                }
            }
            return dp[0][len + 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}