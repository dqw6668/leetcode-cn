package editor.cn;

import sun.misc.Unsafe;

import java.util.*;

/**
 * Created by Five on 2020/8/27 19:04
 */
public class Debug {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = solution.fun(new int[]{1,5,3,6,4,8,9,10});
        int[] test5 = solution.fun(new int[]{1,2,3,4,5,8,9,10});
        int[] test2 = solution.fun(new int[]{1,1,1});
        int[] test3 = solution.fun(new int[]{1});
        int[] test4 = solution.fun(new int[]{});
        for (int i : test5) {
            System.out.print(i + " ");
        }
    }
}
class Solution {
    public int[] fun(int[] arr) {
        if (null == arr) return null;
        int len = arr.length;
        if (len == 1) return new int[]{-1};
        int[] res = new int[len];
        // 存放的是下标，不是arr[i]
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i])
                stack.pop();
            if (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                res[i] = arr[stack.peek()];
            }
            else
                res[i] = -1;
            stack.push(i);
        }
        return res;
    }
}
