//在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 36
//5 的整数。 
//
// 火车票有三种不同的销售方式： 
//
// 
// 一张为期一天的通行证售价为 costs[0] 美元； 
// 一张为期七天的通行证售价为 costs[1] 美元； 
// 一张为期三十天的通行证售价为 costs[2] 美元。 
// 
//
// 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第
// 5 天、第 6 天、第 7 天和第 8 天。 
//
// 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。 
//
// 
//
// 示例 1： 
//
// 输入：days = [1,4,6,7,8,20], costs = [2,7,15]
//输出：11
//解释： 
//例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
//在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
//在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
//在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
//你总共花了 $11，并完成了你计划的每一天旅行。
// 
//
// 示例 2： 
//
// 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
//输出：17
//解释：
//例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划： 
//在第 1 天，你花了 costs[2] = $15 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。
//在第 31 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 31 天生效。 
//你总共花了 $17，并完成了你计划的每一天旅行。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= days.length <= 365 
// 1 <= days[i] <= 365 
// days 按顺序严格递增 
// costs.length == 3 
// 1 <= costs[i] <= 1000 
// 
// Related Topics 动态规划


package editor.cn.dp;
//Java：最低票价
public class P983MinimumCostForTickets{
    public static void main(String[] args) {
        Solution solution = new P983MinimumCostForTickets().new Solution();
        // TO TEST
        System.out.println(solution.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length-1];
        int index = 0;
        // dp[i] i为到第i天的最小花费
        int[] dp = new int[lastDay+1];
        for (int i = 1; i <= lastDay; i++) {
            if (i == days[index]) {
                int cost = Math.min(Math.min(dp[i-1] + costs[0], dp[i-7 > 0 ? i-7 : 0] + costs[1]),
                        dp[i-30 > 0 ? i-30 : 0] + costs[2]);
                dp[i] = cost;
                index++;
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[lastDay];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}