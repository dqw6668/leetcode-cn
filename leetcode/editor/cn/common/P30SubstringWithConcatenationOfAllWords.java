//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
// 
// Related Topics 哈希表 双指针 字符串 
// 👍 323 👎 0


package editor.cn.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Java：串联所有单词的子串
public class P30SubstringWithConcatenationOfAllWords{
    public static void main(String[] args) {
        Solution solution = new P30SubstringWithConcatenationOfAllWords().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0)
            return res;
        int wordLen = words[0].length();
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String word : words) {
            allWords.put(word, allWords.getOrDefault(word, 0) + 1);
        }
        // 遍历所有起点i
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            HashMap<String, Integer> hasWords = new HashMap<>();
            int num = 0;
            while (num < wordNum) {
                String word = s.substring(i + num * wordLen, i + (num + 1)* wordLen);
                if (allWords.containsKey(word)) {
                    int value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, value + 1);
                    if (value + 1 > allWords.get(word))
                        break;
                }
                else {
                    break;
                }
                num++;
            }
            if (num == wordNum)
                res.add(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}