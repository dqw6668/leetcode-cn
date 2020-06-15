//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


package editor.cn.common;
//Java：最长公共前缀
public class P14LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 特判
        int len = strs.length;
        if (len == 0)
            return "";
        if (len == 1)
            return strs[0];
        // 用stringbuffer比字符串效率稍高
        StringBuffer res = new StringBuffer();
        // 每次比较第i个char
        char c;
        int minLen = Integer.MAX_VALUE;
        // 最长公共前缀不会比最短的字符串长
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        // 对于每一个char
        for (int i = 0; i < minLen; i++) {
            c = strs[0].charAt(i);
            // 比较所有的字符串，某一个不匹配则到最后了
            for (int j = 1; j < len; j++) {
                if (c != strs[j].charAt(i)) return res.toString();
            }
            // char都相同则加到res中
            res.append(c);
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}