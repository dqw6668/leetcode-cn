package editor.cn.Weeklycompetition;

/**
 * Created by Five on 2020/9/19 16:32
 */
public class TeamWeek2020 {
}
class TeamWeek2020Solution1 {
    public int paintingPlan(int n, int k) {
        if (k == 0) return 1;
        if (k < n) return 0;
        if (n * n == k) return 1;
        if (k == n) return 2 * n;
        int cnt = 0;
        int usedcol = 0, usedrow = 0;

        for (;usedrow <= n; usedrow++) {
            int tmp = k;
            tmp -= (n * usedrow);
            usedcol = 0;
            while (tmp > 0) {
                if ((n - usedrow) > tmp) break;
                tmp -= (n - usedrow);
                usedcol++;
            }
            if (tmp == 0) {
                cnt += Combination1(n, usedrow) * Combination1(n, usedcol);
            }
        }

        return cnt;
    }

    private static int Combination1(int n, int k) {
        int a=1,b=1;
        if(k>n/2) {
            k=n-k;
        }
        for(int i=1;i<=k;i++) {
            a*=(n+1-i);
            b*=i;
        }
        return a/b;
    }
}