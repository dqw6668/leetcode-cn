//给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。 
//
// 示例 1: 
//输入: 
//
// 
//"bbbab"
// 
//
// 输出: 
//
// 
//4
// 
//
// 一个可能的最长回文子序列为 "bbbb"。 
//
// 示例 2: 
//输入: 
//
// 
//"cbbd"
// 
//
// 输出: 
//
// 
//2
// 
//
// 一个可能的最长回文子序列为 "bb"。 
// Related Topics 动态规划


package editor.cn.dp;
//Java：最长回文子序列
public class P516LongestPalindromicSubsequence{
    public static void main(String[] args) {
        Solution solution = new P516LongestPalindromicSubsequence().new Solution();
        // TO TEST
        System.out.println(solution.longestPalindromeSubseq("cbbd"));
        System.out.println(solution.longestPalindromeSubseq("bbbab"));
        System.out.println(solution.longestPalindromeSubseq("accb"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len < 2)
            return len;

        // dp表示s[i...j]最长回文子序列的长度解
        int[][] dp = new int[len+1][len+1];
        // TODO base状态初始
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][len-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}