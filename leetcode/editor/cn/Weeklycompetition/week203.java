package editor.cn.Weeklycompetition;

import java.util.*;

/**
 * Created by Five on 2020/8/23 11:19
 */
public class week203 {
    public static void main(String[] args) {
        week203Solution1 solution1 = new week203Solution1();
        solution1.mostVisited(4, new int[]{1,3,1,2});
    }
}

class week203Solution1 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] cnt = new int[n + 1];
        int index = rounds[0];
        cnt[index]++;
        List<Integer> list = new LinkedList<>();
        for (int round : rounds) {
            // 跳过起始round
            while (round != index) {
                // index增加
                index = index % n + 1;
                cnt[index]++;
            }
        }

        int maxNum = 0;
        for (int i : cnt) {
            maxNum = Math.max(maxNum, i);
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == maxNum)
                list.add(i);
        }
        return list;
    }
}
class week203Solution2 {
    public int maxCoins(int[] piles) {
        int len = piles.length;
        Arrays.sort(piles);
        int res = 0;
        int index = len - 1;
        for (int i = 0; i < len/3; i++) {
            res += piles[index - 1];
            index -= 2;
        }
        return res;
    }
}

class week203Solution3 {
    /**
     * set中存 0所在的下标，下边与下标之间都看作1，每次增加一个index（把1换为0）
     * @param arr
     * @param m
     * @return
     */
    public int findLatestStep(int[] arr, int m) {
        TreeSet<Integer> set=new TreeSet<>();
        set.add(0);
        set.add(arr.length+1);
        if(arr.length==m) return arr.length;
        int n=arr.length;
        for (int i = n-1; i >=0; i--) {
            int index=arr[i];
            int a=set.lower(index);
            int b=set.higher(index);
            if(index-a-1==m||b-index-1==m){
                return i;
            }
            set.add(index);
        }
        return -1;
    }
}

class week203Solution4 {
    public int stoneGameV(int[] stoneValue) {
        int N = stoneValue.length;
        // dp[i][j] 表示{i..j}最大得分
        int[][] dp = new int[N][N];
        // 前缀和
        int[] preSum = new int[N];
        preSum[0] = stoneValue[0];
        for (int i = 1; i < N; i++) {
            preSum[i] = preSum[i - 1] + stoneValue[i];
        }
        // 区间长度
        for (int len = 2; len <= N; len++) {
            // 左边下边
            for (int i = 0; i < (N - len + 1); i++) {
                // 右边下标
                int j = i + len - 1;
                // 遍历分割点mid
                for (int m = i; m < j; m++) {
                    int leftValue = dp[i][m];
                    int rightValue = dp[m + 1][j];
                    int leftScore = preSum[m] - (i == 0 ? 0 : preSum[i - 1]);
                    int rightScore = preSum[j] - preSum[m];

                    if (leftScore == rightScore) {
                        int score = Math.max(leftValue, rightValue) + leftScore;
                        dp[i][j] = Math.max(dp[i][j], score);
                    }
                    // 丢掉左边
                    else if (leftScore > rightScore) {
                        dp[i][j] = Math.max(dp[i][j], rightValue + rightScore);
                    }
                    else {
                        dp[i][j] = Math.max(dp[i][j], leftValue + leftScore);
                    }
                }
            }
        }
        return dp[0][N-1];
    }
}
