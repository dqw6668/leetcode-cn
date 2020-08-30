package editor.cn.Weeklycompetition;

/**
 * Created by Five on 2020/8/30 17:05
 */
public class Week204 {
    public static void main(String[] args) {
        Week204Solution1 solution1 = new Week204Solution1();
        System.out.println(solution1.containsPattern(new int[]{1,2,1,2,1,1,1,3}, 2,2));
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