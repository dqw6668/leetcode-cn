//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 示例 1: 
//
// 输入: "hello"
//输出: "holle"
// 
//
// 示例 2: 
//
// 输入: "leetcode"
//输出: "leotcede" 
//
// 说明: 
//元音字母不包含字母"y"。 
// Related Topics 双指针 字符串


package editor.cn.twoPoint;

import java.util.Arrays;
import java.util.HashSet;

//Java：反转字符串中的元音字母
public class P345ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // TO TEST
        System.out.println(solution.reverseVowels("hello"));
        System.out.println(solution.reverseVowels("leotcede"));
    }
}
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public static HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'o', 'e', 'i', 'u', 'A', 'O', 'E', 'I', 'U'));

        public String reverseVowels(String s) {
            // 特判
            int len = s.length();
            if (len < 2)
                return s;
            // 双指针
            int left = 0, right = len - 1;
            // 存放转换结果的数组
            char[] res = new char[len];
            while (left <= right) {
                char charI = s.charAt(left);
                char charJ = s.charAt(right);
                if (!set.contains(charI))
                    res[left++] = charI;
                else if (!set.contains(charJ))
                    res[right--] = charJ;
                // 都是元音则换位置
                else {
                    res[left++] = charJ;
                    res[right--] = charI;
                }
            }
            // 循环完后要返回字符串
            return new String(res);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

