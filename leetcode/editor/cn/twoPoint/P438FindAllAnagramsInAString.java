//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表


package editor.cn.twoPoint;

import java.util.ArrayList;
import java.util.List;

//Java：找到字符串中所有字母异位词
public class P438FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new P438FindAllAnagramsInAString().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s == "" || p == "" || s.length() == 0 || p.length() == 0 || s.length() < p.length())
                return res;
            // 记录字符串t中字符的频率，也就是窗口内需要匹配的字符对应频率
            int[] need = new int[128];
            for (char c : p.toCharArray())
                need[c]++;
            int left = 0, right = 0;
            int match = 0;
            while (right < s.length()) {
                char charRight = s.charAt(right);
                need[charRight]--;
                // 如果charRight在t中，那么个数还大于等于0，则匹配了一个
                // 如果charRight不在t中，因为need[charRight]初始为0，此时一定小于0,不进行任何操作
                if (need[charRight] >= 0)
                    match++;
                right++;
                while (match == p.length()) {
                    // 当匹配时，且窗口内与p中字母相同，加入res
                    if (right - left == p.length())
                        res.add(left);
                    char charLeft = s.charAt(left);
                    need[charLeft]++;
                    // 不在 t 中出现的字符，移出窗口，最终能够达到的最大值 need[charLeft] = 0
                    // 如果恰好移出了需要匹配的一个字符，那么这里 need[charLeft] > 0, 也就是还要匹配字符 charLeft，此时 match--
                    if (need[charLeft] > 0)
                        match--;
                    left++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}