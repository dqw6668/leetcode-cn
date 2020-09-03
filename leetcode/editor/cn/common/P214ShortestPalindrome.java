//给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。 
//
// 示例 1: 
//
// 输入: "aacecaaa"
//输出: "aaacecaaa"
// 
//
// 示例 2: 
//
// 输入: "abcd"
//输出: "dcbabcd" 
// Related Topics 字符串 
// 👍 213 👎 0


package editor.cn.common;
//Java：最短回文串
public class P214ShortestPalindrome{
    public static void main(String[] args) {
        Solution solution = new P214ShortestPalindrome().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String shortestPalindrome(String s) {
            String ss= s + '#' + new StringBuilder(s).reverse();
            int n = ss.length();
            char[] c = ss.toCharArray();
            int[] next = new int[n + 1];
            // 以便于不匹配时++回到最开始下标0
            next[0] = -1;
            next[1] = 0;
            int slow = 0, fast = 2;
            while (fast <= n) {
                if (slow == -1 || c[slow] == c[fast - 1]) {
                    slow++;
                    next[fast] = slow;
                    fast++;
                }
                else {
                    slow = next[slow];
                }
            }
            String res = new StringBuilder(s.substring(next[n])).reverse().append(s).toString();
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}