package editor.cn.Weeklycompetition;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Five on 2020/8/30 17:05
 */
public class Week204 {
    public static void main(String[] args) {
        Week204Solution1 solution1 = new Week204Solution1();
        System.out.println(solution1.containsPattern(new int[]{1,2,1,2,1,1,1,3}, 2,2));

        Week204Solution2 solution2 = new Week204Solution2();
        System.out.println(solution2.getMaxLen(new int[]{-17,-9,17,-3,-5,-13,2,6,0}));
    }
}

class Week204Solution1 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int len = arr.length;
        if (len < k * m) return false;
        int[] dp = new int[len + 1];
        for (int i = m; i <= len; i++) {
            dp[i] = 1;
        }
        int flag = 0;
        for (int i = 2 * m; i <= len; i++) {
            flag = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i - 1 - j] == arr[i - 1 - j - m])
                    flag++;
            }
            if (flag == m)
                dp[i] = dp[i - m] + 1;
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= k)
                return true;
        }
        return false;
    }
}

class Week204Solution2 {
    public int getMaxLen(int[] nums) {
        int len = nums.length;
        if (len < 1) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0, pre = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                pre = i;
                stack.clear();
            }
            else if (nums[i] < 0) {
                stack.add(i);
            }
            if (stack.size() % 2 == 0) {
                res = Math.max(res, i - pre);
            }
            else {
                res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }
}