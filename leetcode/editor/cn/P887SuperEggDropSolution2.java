package editor.cn;

public class P887SuperEggDropSolution2 {
    public static void main(String[] args) {
        Solution solution = new P887SuperEggDropSolution2().new Solution();
        // TO TEST
        long startTimes = System.currentTimeMillis();
        System.out.println(solution.superEggDrop(2, 100));
        System.out.println("耗时" + (System.currentTimeMillis() - startTimes));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int superEggDrop(int K, int N) {
            // k个鸡蛋可以扔m次 可以测出的楼层解
            int[][] dp = new int[K+1][N+1];
            for (int i = 0; i <= N; i++) {
                dp[0][i] = 0;
                dp[1][i] = i;
            }
            for (int i = 0; i <= K; i++) {
                dp[i][1] = 1;
                dp[i][0] = 0;
            }
            int m = 2;
            // 第二层循环中找出可以扔m次对应的楼层，for条件需要用m-1
            for (; dp[K][m-1] < N; m++) {
                for (int i = 2; i <= K; i++) {
                    dp[i][m] = dp[i-1][m-1] + dp[i][m-1] + 1;
                }
            }
            return m-1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
