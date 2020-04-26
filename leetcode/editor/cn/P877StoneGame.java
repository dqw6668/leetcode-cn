//亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。 
//
// 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。 
//
// 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
// 
//
// 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。 
//
// 
//
// 示例： 
//
// 输入：[5,3,4,5]
//输出：true
//解释：
//亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
//假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
//如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
//如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
//这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= piles.length <= 500 
// piles.length 是偶数。 
// 1 <= piles[i] <= 500 
// sum(piles) 是奇数。 
// 
// Related Topics 极小化极大 数学 动态规划


package editor.cn;
//Java：石子游戏
public class P877StoneGame{
    public static void main(String[] args) {
        Solution solution = new P877StoneGame().new Solution();
        // TO TEST
        System.out.println(solution.stoneGame(new int[]{5,3,4,5}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        if (len <= 2)
            return true;
        // i,j,n表示石子i...j中先手和后手所得分数
        // TODO base状态

        int[][][] dp = new int[len][len][2];
        for (int i = 0; i < len; i++) {
            dp[i][i][0] = piles[i];
            dp[i][i][1] = 0;
        }
        // 辅助增长k，斜着遍历，j比i逐渐大k
        for (int k = 1; k < len; k++) {
            for (int i = 0; i < len - k; i++) {
                int j = i + k;
                int left = dp[i + 1][j][1] + piles[i];
                int right = dp[i][j - 1][1] + piles[j];
                if (left > right) {
                    dp[i][j][0] = left;
                    dp[i][j][1] = dp[i + 1][j][0];
                }
                else {
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }
        boolean res = dp[0][len-1][0] > dp[0][len-1][1];
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}