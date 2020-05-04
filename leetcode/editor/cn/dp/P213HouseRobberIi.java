//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
//装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
// Related Topics 动态规划


package editor.cn.dp;
//Java：打家劫舍 II
public class P213HouseRobberIi{
    public static void main(String[] args) {
        Solution solution = new P213HouseRobberIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
    // 在打家劫舍1的基础上，考虑仅打劫第一家，或仅打劫最后一家
        int len = nums.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return nums[0];
        if (len == 2)
            return Math.max(nums[0], nums[1]);
        int pre = nums[0], cur = Math.max(pre, nums[1]);
        int tmp;
        for (int i = 2; i < len-1; i++) {
            tmp = pre;
            pre = cur;
            cur = Math.max(tmp + nums[i], cur);
        }

        int pre2 = nums[1], cur2 = Math.max(pre2,nums[2]);
        for (int i = 3; i < len; i++) {
            tmp = pre2;
            pre2 = cur2;
            cur2 = Math.max(tmp + nums[i], cur2);
        }
        return Math.max(cur2, cur);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}