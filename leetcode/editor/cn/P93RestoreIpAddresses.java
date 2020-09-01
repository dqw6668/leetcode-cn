//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。 
//
// 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
// 和 "192.168@1.1" 是 无效的 IP 地址。 
//
// 
//
// 示例 1： 
//
// 输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 402 👎 0


package editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：复原IP地址
public class P93RestoreIpAddresses{
    public static void main(String[] args) {
        Solution solution = new P93RestoreIpAddresses().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new LinkedList<>();
        public List<String> restoreIpAddresses(String s) {
            int[] segments = new int[4];
            backTrack(s, 0, 0, segments);
            return res;
        }

        private void backTrack(String s, int start, int indexOfNum, int[] seg) {
            if (indexOfNum == 4) {
                if (start == s.length()) {
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < 3; i++) {
                        sb.append(seg[i]).append(".");
                    }
                    sb.append(seg[3]);
                    res.add(sb.toString());
                }
                return;
            }
            if (start == s.length())
                return;
            if (s.charAt(start) == '0') {
                seg[indexOfNum] = 0;
                backTrack(s, start + 1, indexOfNum + 1, seg);
            }
            int tmp = 0;
            for (int end = start; end < s.length(); end++) {
                tmp = tmp*10 + (s.charAt(end) - '0');
                if (tmp > 0 && tmp <= 255) {
                    seg[indexOfNum] = tmp;
                    backTrack(s, end + 1, indexOfNum + 1, seg);
                }
                else
                    break;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}