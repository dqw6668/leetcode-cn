//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串


package editor.cn;
//Java：实现 strStr()
public class P28ImplementStrstr{
    public static void main(String[] args) {
        Solution solution = new P28ImplementStrstr().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle == null || needle.equals(""))
                return 0;
            if (haystack.equals(""))
                return -1;

            int lenText = haystack.length(), lenPat = needle.length();
            if (lenText < lenPat)
                return -1;
            else if (lenText == lenPat) {
                if(haystack.equals(needle)) {
                    return 0;
                }else
                    return -1;
            }
            int[][] dp = new int[lenText][256];
            dp[0][needle.charAt(0)] = 1;
            int lastPat = 0;
            for (int i = 1; i < lenPat; i++) {
                for (int j = 0; j < 256; j++) {
                    dp[i][j] = dp[lastPat][j];
                }
                dp[i][needle.charAt(i)] = 1 + i;
                lastPat = dp[lastPat][needle.charAt(i)];
            }

            int search = 0;
            for (int i = 0; i < lenText; i++) {
                search = dp[search][haystack.charAt(i)];
                if (search == lenPat)
                    return i - lenPat + 1;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}