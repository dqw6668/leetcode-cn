package editor.cn.Weeklycompetition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Week214 {
    public static void main(String[] args) {
    }
}

class Week214Solution1 {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] tmp = new int[n + 1];
        int res = 1;
        tmp[0] = 0;
        tmp[1] = 1;
        for (int i = 1; i * 2 + 1 <= n; i++) {
            tmp[i * 2] = tmp[i];
            res = Math.max(res, tmp[i]);
            tmp[i * 2 + 1] = tmp[i + 1] + tmp[i];
            res = Math.max(res, tmp[i * 2 + 1]);
        }
        return res;
    }
}

class Week214Solution2 {
}

class Week214Solution3 {
}