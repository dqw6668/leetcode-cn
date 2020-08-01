//给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如
//同俄罗斯套娃一样。 
//
// 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 说明: 
//不允许旋转信封。 
//
// 示例: 
//
// 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出: 3 
//解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
// 
// Related Topics 二分查找 动态规划 
// 👍 172 👎 0


package editor.cn;

import java.util.Arrays;

//Java：俄罗斯套娃信封问题
public class P354RussianDollEnvelopes{
    public static void main(String[] args) {
        Solution solution = new P354RussianDollEnvelopes().new Solution();
        // TO TEST
        //solution.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}});
        System.out.println(solution.maxEnvelopes(new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    // 排序后最长子序列问题
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            if (null == envelopes || envelopes.length == 0)
                return 0;
            Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1]: o1[0] - o2[0]);
            // 排序后找出最长上升子序列 envelopes[i][1]
            // dp[i]表示以envelopes[i][1]结尾的子序列最长长度
            int[] dp = new int[envelopes.length + 1];
            Arrays.fill(dp, 1);
            int res = 1;
            for (int i = 1; i < envelopes.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (envelopes[j][1] < envelopes[i][1]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                        res = Math.max(res, dp[i]);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}