//有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，每个栅栏柱可以用其中一种颜色进行上色。 
//
// 你需要给所有栅栏柱上色，并且保证其中相邻的栅栏柱 最多连续两个 颜色相同。然后，返回所有有效涂色的方案数。 
//
// 注意: 
//n 和 k 均为非负的整数。 
//
// 示例: 
//
// 输入: n = 3，k = 2
//输出: 6
//解析: 用 c1 表示颜色 1，c2 表示颜色 2，所有可能的涂色方案有:
//
//            柱 1    柱 2   柱 3     
// -----      -----  -----  -----       
//   1         c1     c1     c2 
//   2         c1     c2     c1 
//   3         c1     c2     c2 
//   4         c2     c1     c1  
//   5         c2     c1     c2
//   6         c2     c2     c1
// 
// Related Topics 动态规划 
// 👍 57 👎 0


package editor.cn;
//Java：栅栏涂色
public class P276PaintFence{
    public static void main(String[] args) {
        Solution solution = new P276PaintFence().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(int n, int k) {
        // dp[i] 表示i个栅栏的方案个数
        int[] dp = new int[n + 2];
        // 一个栅栏可以放k种颜色中的一种
        dp[1] = k;
        dp[2] = k * k;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] * (k - 1) + dp[i - 2] * (k - 1);
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}