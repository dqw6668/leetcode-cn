package editor.cn.Weeklycompetition;

/**
 * Created by Five on 2020/9/13 14:45
 */
public class Week206 {
}
class Week206Solution2 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        // rank[i][j]表示j在i的亲密排行中排第几 从0到n-2
        int[][] rank = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                rank[i][preferences[i][j]] = j;
            }
        }
        //partner[i] 表示i的搭档
        int[] partner = new int[n];
        for (int[] pair : pairs) {
            partner[pair[0]] = pair[1];
            partner[pair[1]] = pair[0];
        }
        int res = 0;
        // 遍历所有人
        for (int i = 0; i < n; i++) {
            boolean happy = true;
            // 遍历i这个人的所有亲密排行中的人
            for (int j = 0; j < n; j++) {
                // 如果i的搭档不如j 且 j的搭档不如i 不开心
                if (rank[i][partner[i]] > rank[i][j] && rank[j][partner[j]] > rank[j][i])
                    happy = false;
            }
            if (!happy)
                res++;
        }
        return res;
    }
}