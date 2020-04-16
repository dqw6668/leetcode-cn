//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划


package editor.cn;
//Java：最长回文子串
public class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("aabbasds"));
        System.out.println(solution.longestPalindrome("abcfggfca"));
        System.out.println(solution.longestPalindrome("xcvcxz"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (null == s || s.length() < 2)
            return s;
        int resL = 0, resR = 0;
        int maxLen = 1;
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {  // 遍历出所有可能的字符串
                if (s.charAt(l) == s.charAt(r) && ((r - l) <= 2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    if (maxLen < r - l + 1) {
                        maxLen = r - l + 1;
                        resL = l;
                        resR = r;
                    }
                }
            }
        }
        return s.substring(resL, resR + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}