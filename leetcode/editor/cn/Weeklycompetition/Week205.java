package editor.cn.Weeklycompetition;

/**
 * Created by Five on 2020/9/6 20:30
 */
public class Week205 {
}
class Week205Solution1 {
    public String modifyString(String s) {
        int len = s.length();
        char[] carr = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (carr[i] == '?') {
                char c = 'a';
                while ((i != 0 && carr[i - 1] == c) || (i < len - 1 && carr[i + 1] == c)) {
                    c++;
                }
                carr[i] = c;
            }
        }
        return String.valueOf(carr);
    }
}

class Week205Solution3 {
    public int minCost(String s, int[] cost) {
        char[] carr = s.toCharArray();
        int res = 0;
        for (int i = 0; i < carr.length; i++) {
            char c = carr[i];
            int maxCost = cost[i];
            int sum = cost[i];
            while (i < carr.length - 1 && carr[i + 1] == c) {
                maxCost = Math.max(maxCost, cost[i + 1]);
                sum += cost[++i];
            }
            if (sum != maxCost) {
                res += sum - maxCost;
            }
        }
        return res;
    }
}