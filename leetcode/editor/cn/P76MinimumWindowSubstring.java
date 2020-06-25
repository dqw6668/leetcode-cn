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

import java.util.Arrays;

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
            // 初始结果
            int resl = 0, resr = s.length() + 1;
            // 滑动窗口[left..right],初始时窗口内为空
            int left = 0, right = -1;
            // 计数t中所有字符个数
            int count = t.length();
            // 计数t中字符出现次数
            int[] hash = new int[256];
            // 不是我们要找的字符设为无效值
            Arrays.fill(hash, Integer.MAX_VALUE);
            // 要找的字符次数初始化
            for (int i = 0; i < t.length(); i++) {
                if (hash[t.charAt(i)] == Integer.MAX_VALUE)
                    hash[t.charAt(i)] = 1;
                else
                    hash[t.charAt(i)]++;
            }
            while (right < s.length() - 1) {
                // right右移,找到一个，要查找数减一
                right++;
                // 意味着下标right的字符是要找的
                if (hash[s.charAt(right)] != Integer.MAX_VALUE) {
                    // 当要查找的字符没有多余时
                    if (hash[s.charAt(right)] > 0) {
                        count--;
                    }
                    // 要找的字符数减一
                    hash[s.charAt(right)]--;
                }
                // 找完时，可能有多余的left字符，需要left收缩去除
                if (count == 0) {
                    // 如果该字符是多余的 或者 不是我们要找的，可以移除滑动窗口
                    while (hash[s.charAt(left)] < 0 || hash[s.charAt(left)] == Integer.MAX_VALUE) {
                        if (hash[s.charAt(left)] < 0)
                            hash[s.charAt(left)]++;
                        left++;
                    }
                    if (resr - resl > right - left) {
                        resr = right;
                        resl = left;
                    }
                    // left增加一个位置，找新的窗口
                    hash[s.charAt(left++)]++;
                    count++;
                }
            }
            return resr == s.length() + 1 ? "" : s.substring(resl, resr + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}