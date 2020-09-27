package editor.cn;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class Debug {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new String[]{"./","../","./"}));
    }
}
class Solution {
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
