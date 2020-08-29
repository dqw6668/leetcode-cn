package editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Five on 2020/8/27 19:04
 */
public class Debug {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.wordPattern("aaaa", "dog cat cat dog");
    }
}
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 1) return s;
        int[] index = new int[2];
        int maxLen = 1;
        for (int i = 0; i < 2* len - 1; i++) {
            int left = i / 2;
            int right = i / 2 + i % 2;
            int cnt = 0;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                cnt = right - left + 1;
                left--;
                right++;
                if (cnt > maxLen) {
                    maxLen = cnt;
                    index[0] = left;
                    index[1] = right;
                }
            }
        }
        return s.substring(index[0], index[1] + 1);
    }
}
