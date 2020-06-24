//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


package editor.cn;

//Java：最小覆盖子串
public class P76MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        // TO TEST
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow("A", "A"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            // 特判
            if (null == s || null == t)
                return "";
            int resl = 0, resr = t.length();
            // 双指针
            int left = 0, right = 0;
            // 计数t中所有字符个数
            int count = t.length();
            // 计数t中字符出现次数
            int[] hash = new int[256];
            for (int i = 0; i < t.length(); i++) {
                hash[t.charAt(i)]++;
            }
            while (right < s.length()) {
                // 意味着下标right的字符是要找的
                if (hash[s.charAt(right)] > 0)
                    count--;
                // 找完时，可能有多余的left字符，需要left收缩去除
                if (count == 0) {
                    while (hash[s.charAt(left)] < 0)
                        hash[s.charAt(left++)]++;
                    if (resr - resl > right - left) {
                        resr = right;
                        resl = left;
                    }
                    // left增加一个位置，找新的窗口
                    hash[s.charAt(left++)]++;
                    count++;
                }
                // right右移,找到一个，要查找数减一
                hash[s.charAt(right++)]--;
            }
            System.out.println("s is " + s + " left is " + resl + " right : " + resr);
            return s.substring(resl, resr);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}