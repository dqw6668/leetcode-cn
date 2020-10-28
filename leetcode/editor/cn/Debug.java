package editor.cn;

import java.util.*;

public class Debug {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{3,1,4,5,2,9,8};
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null) return false;
        int len = arr.length;
        if (len == 0 || len == 1) return true;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for(Integer i : map.values()) {
            if (set.contains(i))
                return false;
            set.add(i);
        }
        return true;
    }
}
