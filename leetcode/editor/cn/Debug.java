package editor.cn;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import editor.cn.tree.TreeNode;
/**
 * Created by Five on 2020/8/27 19:04
 */
public class Debug {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Deque<TreeNode> queue = new ArrayDeque<>();
        int i = (int) (1e9 + 7);
        System.out.println(i);
    }
}
class Solution {
    public String[] permutation(String s) {
        char[] carry = s.toCharArray();
        LinkedList<String> list = new LinkedList<>();
        backTrack(list, s, 0, carry);
        return list.toArray(new String[list.size()]);
    }
    private void backTrack(LinkedList<String> list, String s, int index, char[] carry) {
        if (index == s.length()) {
            list.add(new String(carry));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            swp(carry, i, index);
            backTrack(list, s, i + 1, carry);
            swp(carry, i, index);
        }
    }

    private void swp(char[] c, int i, int j) {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }
}
class Solution2 {
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                      // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}

