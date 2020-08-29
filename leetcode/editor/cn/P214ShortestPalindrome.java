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


package editor.cn;
//Java：最短回文串
public class P214ShortestPalindrome{
    public static void main(String[] args) {
        Solution solution = new P214ShortestPalindrome().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String shortestPalindrome(String s) {
            String r = new StringBuilder(s).reverse().toString();
            int n = s.length();
            int i = 0;
            for (; i < n; i++) {
                if (s.substring(0, n - i).equals(r.substring(i))) {
                    break;
                }
            }
            return new StringBuilder(s.substring(n - i)).reverse() + s;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}