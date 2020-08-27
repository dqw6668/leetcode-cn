//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 367 👎 0


package editor.cn.twoPoint;

import java.util.ArrayList;
import java.util.List;

//Java：回文子串
public class P647PalindromicSubstrings{
    public static void main(String[] args) {
        Solution solution = new P647PalindromicSubstrings().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int len = s.length();
            if(len <= 1) return len;
            int res = 0;
            int l = 0, r = 0;
            for (int i = 0; i < 2 * len - 1; i++) {
                l = i/2;
                r = i / 2 + i % 2;
                while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}