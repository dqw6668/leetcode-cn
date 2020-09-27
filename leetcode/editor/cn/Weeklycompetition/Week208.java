package editor.cn.Weeklycompetition;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Five on 2020/9/27 17:28
 */
public class Week208 {
    public static void main(String[] args) {
        Week208Solution1 solution = new Week208Solution1();
        System.out.println(solution.minOperations(new String[]{"./","../","./"}));
    }
}
class Week208Solution1 {
    public int minOperations(String[] logs) {
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals("./"))
                continue;
            else if (logs[i].equals("../")) {
                if (!stack.isEmpty())
                    stack.pop();
                else
                    continue;
            }

            else
                stack.push(logs[i]);
        }
        return stack.size();
    }
}
class Week208Solution4 {
    int max = 0;
    public int maximumRequests(int n, int[][] requests) {
        int cnt = 0;
        //记录每一栋楼转入转出后是否均衡为0
        int[] lou = new int[n];
        backTrack(requests, lou, cnt, 0);
        return max;
    }

    public void backTrack(int[][] requests, int[] lou, int cnt, int index) {
        if (check(lou)) {
            max = Math.max(max, cnt);
        }
        for (int i = index; i < requests.length; i++) {
            lou[requests[i][0]]--;
            lou[requests[i][1]]++;
            backTrack(requests, lou, cnt + 1, i + 1);
            lou[requests[i][0]]++;
            lou[requests[i][1]]--;
        }
    }

    public boolean check(int[] lou) {
        for (int i = 0; i < lou.length; i++) {
            if (lou[i] != 0) return false;
        }
        return true;
    }
}