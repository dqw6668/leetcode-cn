//删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。 
//
// 说明: 输入可能包含了除 ( 和 ) 以外的字符。 
//
// 示例 1: 
//
// 输入: "()())()"
//输出: ["()()()", "(())()"]
// 
//
// 示例 2: 
//
// 输入: "(a)())()"
//输出: ["(a)()()", "(a())()"]
// 
//
// 示例 3: 
//
// 输入: ")("
//输出: [""] 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 247 👎 0


package editor.cn.BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：删除无效的括号
public class P301RemoveInvalidParentheses{
    public static void main(String[] args) {
        Solution solution = new P301RemoveInvalidParentheses().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        set.add(s);
        while (!set.isEmpty()) {
            // 越来越多的删除，只要最小次满足就返回
            for (String s1 : set) {
                if (isValid(s1)) {
                    res.add(s1);
                }
            }
            if (res.size() > 0) return res;
            // 下一层删除循环
            Set<String> nextSet = new HashSet<>();
            for (String s1 : set) {
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) == '(' || s1.charAt(i) == ')')
                        nextSet.add(s1.substring(0, i) + s1.substring(i + 1));
                }
            }
            set = nextSet;
        }
        return res;
    }

    private boolean isValid(String s) {
        char[] charArr = s.toCharArray();
        int cnt = 0;
        for (char c : charArr) {
            if (c == '(')
                cnt++;
            else if (c == ')') {
                if (cnt > 0)
                    cnt--;
                else
                    return false;
            }
        }
        return cnt == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}