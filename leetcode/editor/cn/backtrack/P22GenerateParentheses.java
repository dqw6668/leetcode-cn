//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1164 👎 0


package editor.cn.backtrack;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class P22GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            StringBuffer comb = new StringBuffer(2*n);
            backtrack(n, n, comb, res);
            return res;
        }

        /***
         *
         * @param left 可放的(的数量
         * @param right 可放的)的数量
         * @param comb 当前括号组合
         * @param res
         */
        private void backtrack(int left, int right, StringBuffer comb, List res) {
            // 如果右括号放的比左多，不合法的组合
            if (right < left) return;
            if (right < 0 || left < 0) return;
            if (right == 0 && left == 0) {
                res.add(comb.toString());
                return;
            }

            // 本来是for选择,只有两个，都写出来
            comb.append('(');
            backtrack(left - 1, right, comb, res);
            comb.deleteCharAt(comb.length() - 1);

            comb.append(')');
            backtrack(left, right - 1, comb, res);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}