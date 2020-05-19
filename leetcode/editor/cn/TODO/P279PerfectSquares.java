//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划


package editor.cn.TODO;

import java.util.ArrayList;

//Java：完全平方数
public class P279PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new P279PerfectSquares().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        ArrayList<Integer> dp = new ArrayList<>();

        public int numSquares(int n) {
            if (dp.size() == 0)
                dp.add(0);
            if (dp.size() <= n) {
                for (int i = dp.size(); i <= n; i++) {
                    int min = i;
                    for (int j = 1; j * j <= i; j++) {
                        min = Math.min(dp.get(i - j * j) + 1, min);
                    }
                    dp.add(min);
                }
            }
            return dp.get(n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}