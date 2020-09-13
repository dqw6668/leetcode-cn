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
        System.out.println(solution.brokenCalc(5,8));
    }
}
class Solution {
    Map<Integer, Integer> map = new HashMap();
    public int brokenCalc(int X, int Y) {
        if (X <= Y/2) return (brokenCalc(2*X, Y) + 1);
        if (X >= Y) return X - Y;
        if (map.containsKey(X))
            return map.get(X);
        int res = Math.min(brokenCalc(2*X, Y), brokenCalc(X - 1, Y)) + 1;
        map.put(X, res);
        return res;
    }
}

