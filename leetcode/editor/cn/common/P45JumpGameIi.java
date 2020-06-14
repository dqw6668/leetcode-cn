//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组


package editor.cn.common;
//Java：跳跃游戏 II
public class P45JumpGameIi{
    public static void main(String[] args) {
        Solution solution = new P45JumpGameIi().new Solution();
        // TO TEST
        System.out.println(solution.jump(new int[]{2,1,1,1,1}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int jump(int[] nums) {
//        int len = nums.length;
//        if (len == 0 || len == 1)
//            return 0;
//        int res = 0;
//        int curIndex = len-1;
//        while (curIndex != 0) {
//            int canJump = -1;
//            for (int i = curIndex-1; i >= 0; i--) {
//                if (nums[i] >= curIndex - i)
//                    canJump = Math.max(curIndex - i, canJump);
//            }
//            curIndex -= canJump;
//            res++;
//        }
//        return res;
//    }
//}
    class Solution {
        public int jump(int[] nums) {
            int len = nums.length;
            if (len == 0 || len == 1)
                return 0;
            int canJumpIndex = 0;
            int curIndex = 0;
            int res = 0;
            for (int i = 0; i < len-1; i++) {
                canJumpIndex = Math.max(canJumpIndex, i + nums[i]);
                // 遍历完跳跃点，更新跳跃点
                if (i == curIndex) {
                    curIndex = canJumpIndex;
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}