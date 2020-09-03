//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 170 👎 0


package editor.cn.twoPoint;

import java.util.HashMap;
import java.util.Map;

//Java：字符串的排列
public class P567PermutationInString{
    public static void main(String[] args) {
        Solution solution = new P567PermutationInString().new Solution();
        // TO TEST
        System.out.println(solution.checkInclusion("aba", "abbbabbaba"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length();
            int len2 = s2.length();
            if (len1 > len2) return false;
            int cnt = 0;
            Map<Character, Integer> map = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for (int i = 0; i < len1; i++) {
                char c = s1.charAt(i);
                map.put(c, map.getOrDefault(c, 0).intValue() + 1);
            }
            int left = 0, right = 0;
            while (right < len2) {
                char rc = s2.charAt(right);
                right++;
                if (map.containsKey(rc)) {
                    window.put(rc, window.getOrDefault(rc, 0).intValue() + 1);
                    if(window.get(rc).intValue() == map.get(rc).intValue()) {
                        cnt++;
                    }
                }
                while (right - left >= len1) {
                    if (cnt == map.size())
                        return true;
                    char lc = s2.charAt(left);
                    left++;
                    if (map.containsKey(lc)) {
                        if (map.get(lc).intValue() == window.get(lc).intValue())
                            cnt--;
                        window.put(lc, window.get(lc).intValue() - 1);
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}