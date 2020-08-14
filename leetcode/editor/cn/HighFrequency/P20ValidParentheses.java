//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1769 👎 0


package editor.cn.HighFrequency;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Java：有效的括号
public class P20ValidParentheses{
    public static void main(String[] args) {
        // TO TEST
        //System.out.println(solution.isValid("(){}[]"));
        //System.out.println(solution.isValid("(]"));
        //System.out.println(solution.isValid("){"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, Character> map = new HashMap(){{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};
        public boolean isValid(String s) {
            int len = s.length();
            if(len % 2 == 1) return false;
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < len; i++) {
                if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                    stack.push(s.charAt(i));
                }
                else if(!stack.empty() && map.get(stack.peek()) == s.charAt(i)) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            return stack.empty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

