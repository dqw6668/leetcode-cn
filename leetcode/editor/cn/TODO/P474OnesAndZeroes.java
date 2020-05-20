//在计算机界中，我们总是追求用有限的资源获取最大的收益。 
//
// 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。 
//
// 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。 
//
// 注意: 
//
// 
// 给定 0 和 1 的数量都不会超过 100。 
// 给定字符串数组的长度不会超过 600。 
// 
//
// 示例 1: 
//
// 
//输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
//输出: 4
//
//解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
// 
//
// 示例 2: 
//
// 
//输入: Array = {"10", "0", "1"}, m = 1, n = 1
//输出: 2
//
//解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
// 
// Related Topics 动态规划


package editor.cn.TODO;

//Java：一和零
public class P474OnesAndZeroes {
    public static void main(String[] args) {
        Solution solution = new P474OnesAndZeroes().new Solution();
        // TO TEST
        System.out.println(Integer.bitCount(Integer.parseInt("0", 2)));
        System.out.println(solution.findMaxForm(new String[]{"10", "0", "1"}, 1,1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {

        private int[] calcZeroAndOne(String str) {
            int[] res = new int[2];
            for (char c : str.toCharArray()) {
                res[c - '0']++;
            }
            return res;
        }

        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            dp[0][0] = 0;
            for (String s : strs) {
                int[] zeroAndOne = calcZeroAndOne(s);
                int zeros = zeroAndOne[0];
                int ones = zeroAndOne[1];
                for (int i = m; i >= zeros; i--) {
                    for (int j = n; j >= ones; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                    }
                }
            }
            return dp[m][n];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}