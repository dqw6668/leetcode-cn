//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 186 👎 0


package editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：单词规律
public class P290WordPattern{
    public static void main(String[] args) {
        Solution solution = new P290WordPattern().new Solution();
        // TO TEST
        System.out.println(solution.wordPattern("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd"
                ,"s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean wordPattern(String pattern, String str) {
            String[] words = str.split(" ");
            if (words.length != pattern.length())
                return false;
            Map index = new HashMap();
            // 分别建立p和s的映射，如果出现不一样就false
            for (Integer i = 0; i < words.length; ++i)
                if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                    return false;
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}