//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 861 👎 0


package editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
        System.out.println(solution.letterCombinations("233"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, String> map = new HashMap(){{
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
        }};
        List<String> res = new ArrayList();
        public List<String> letterCombinations(String digits) {
            int len = digits.length();
            if (len > 0)
                backtrack("", 0, len, digits);
            return res;
        }
        private void backtrack(String comb, int index, int maxIndex, String digits){
            if (index == maxIndex) {
                res.add(comb);
                return;
            }
            char[] charArr = map.get(Integer.parseInt(String.valueOf(digits.charAt(index)))).toCharArray();
            for (char c : charArr) {
                backtrack(new StringBuffer(comb).append(c).toString(), index + 1, maxIndex, digits);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}