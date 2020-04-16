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
        System.out.println(solution.longestPalindrome("bab"));
        System.out.println(solution.longestPalindrome("aba"));
        System.out.println(solution.longestPalindrome("baabcsdasbad"));
        System.out.println(solution.longestPalindrome("abcfgcba"));
        System.out.println(solution.longestPalindrome("text"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        String res = "";
        for (int i = 0; i < len; i++) {
            String tmp = expandString(i, s);
            res = res.length() > tmp.length() ? res : tmp;
        }
        return res;
    }

    public String expandString(int index, String s) {
        int left = index, right = index;
        while (left > 0 && right < s.length() - 1) {
             if (s.charAt(--left) != s.charAt(++right)) {
                 left++;
                 right--;
                 break;
             }
        }
        int left2 = index, right2 = left2 + 1;
        while (left2 > 0 && right2 < s.length() - 1) {
            if (s.charAt(--left2) != s.charAt(++right2)) {
                left2++;
                right2--;
                break;
            }
        }
        if (right2 - left2 > right - left)
            return s.substring(left2, right2);
        return s.substring(left, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}