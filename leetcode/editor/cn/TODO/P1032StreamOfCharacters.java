//按下述要求实现 StreamChecker 类： 
//
// 
// StreamChecker(words)：构造函数，用给定的字词初始化数据结构。 
// query(letter)：如果存在某些 k >= 1，可以用查询的最后 k个字符（按从旧到新顺序，包括刚刚查询的字母）拼写出给定字词表中的某一字词时，返
//回 true。否则，返回 false。 
// 
//
// 
//
// 示例： 
//
// StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // 初始化字典
//streamChecker.query('a');          // 返回 false
//streamChecker.query('b');          // 返回 false
//streamChecker.query('c');          // 返回 false
//streamChecker.query('d');          // 返回 true，因为 'cd' 在字词表中
//streamChecker.query('e');          // 返回 false
//streamChecker.query('f');          // 返回 true，因为 'f' 在字词表中
//streamChecker.query('g');          // 返回 false
//streamChecker.query('h');          // 返回 false
//streamChecker.query('i');          // 返回 false
//streamChecker.query('j');          // 返回 false
//streamChecker.query('k');          // 返回 false
//streamChecker.query('l');          // 返回 true，因为 'kl' 在字词表中。 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 2000 
// 1 <= words[i].length <= 2000 
// 字词只包含小写英文字母。 
// 待查项只包含小写英文字母。 
// 待查项最多 40000 个。 
// 
// Related Topics 字典树 
// 👍 37 👎 0


package editor.cn.TODO;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Java：字符流
public class P1032StreamOfCharacters{
    public static void main(String[] args) {
        // TO TEST
        String s = new String("11");
        StreamChecker streamChecker = new StreamChecker(new String[]{"cd", "f", "kl"});
        System.out.println(streamChecker.query('a'));
        System.out.println(streamChecker.query('b'));
        System.out.println(streamChecker.query('c'));
        System.out.println("ok " + streamChecker.query('d'));
        System.out.println(streamChecker.query('e'));
        System.out.println("ok " + streamChecker.query('f'));
        System.out.println(streamChecker.query('g'));
        System.out.println(streamChecker.query('h'));
        System.out.println(streamChecker.query('i'));
        System.out.println(streamChecker.query('j'));
        System.out.println(streamChecker.query('k'));
        System.out.println("ok " + streamChecker.query('l'));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class StreamChecker {
        Map<String, Boolean> map = new HashMap();
        int maxLen = 0;
        LinkedList<Character> lruList = new LinkedList();
        public StreamChecker(String[] words) {
            for (String s: words) {
                maxLen = Math.max(s.length(), maxLen);
                map.put(s, true);
            }
        }

        public boolean query(char letter) {
            if (lruList.size() == maxLen) {
                lruList.removeFirst();
            }
            lruList.addLast(letter);
            StringBuilder sb = new StringBuilder();
            for (int i = lruList.size() - 1; i >= 0; i--) {
                StringBuilder newSb = new StringBuilder().append(lruList.get(i)).append(sb);
                sb = newSb;
                if (map.getOrDefault(sb.toString(), false))
                    return true;
            }
            return false;
        }
    }

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
//leetcode submit region end(Prohibit modification and deletion)
}