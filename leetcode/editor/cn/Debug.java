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
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        String[] arr = str.split(" ");
        int lenP = pattern.length();
        int lenS = arr.length;
        if (lenP != lenS) return false;
        for (int i = 0; i < lenP; i++) {
            if (map.containsKey(pattern.charAt(i))) {
                String tmp = map.get(pattern.charAt(i));
                if (!tmp.equals(arr[i]))
                    return false;
            }
            else {
                if (map.containsValue(arr[i]))
                    return false;
                map.put(pattern.charAt(i), arr[i]);
            }
        }
        return true;
    }
}
