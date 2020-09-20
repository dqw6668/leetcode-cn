package editor.cn;

import sun.misc.Unsafe;

import java.util.*;
import java.util.concurrent.Executors;

/**
 * Created by Five on 2020/8/27 19:04
 */
public class Debug {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution3 solution2 = new Solution3();
//        System.out.println(solution.reorderSpaces("  this   is  a sentence "));
        System.out.println(solution2.maxProductPath(new int[][]{{ 1, 4,4,0},{-2, 0,0,1},{ 1,-1,1,1}}));
    }

    public static int Combination1(int n, int k) {
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
class Solution {
    public String reorderSpaces(String text) {
        int len = text.length();
        text.replaceAll(" ", "#");
        String[] s = text.replaceAll(" ", "#").split("#");
        int sNum = s.length;
        int spaceNum = 0;
        char[] arr = text.toCharArray();
        char[] res = new char[len];
        for (int i = 0; i < len ;i++) {
            if (arr[i] == ' ')
                spaceNum++;
        }
        int sn = spaceNum / (sNum - 1);
        int sm = spaceNum % (sNum - 1);
        int a = len - 1, j = len - 1;
        for ( int k = 0; k < sm; k++) {
            res[j--] = ' ';
        }
        while(a >= 0 && j >= 0) {
            while (arr[a] == ' ')
                a--;
            while (arr[a] != ' ') {
                res[j--] = arr[a--];
            }
            for ( int k = 0; k < sn; k++) {
                res[j--] = ' ';
            }
        }
        return new String(res);
    }
}
class Solution2 {
    Set<String> set = new HashSet();
    int maxR = 1;
    public int maxUniqueSplit(String s) {
        int len = s.length();
        if (len < 2) return len;
        backTrack(s, 0, len);
        return maxR;
    }
    private void backTrack(String s, int start, int end) {
        if (start == s.length()) {
            maxR = Math.max(maxR, set.size());
            return;
        }
        for ( int i = start; i < end; i++) {
            String div = s.substring(start, i + 1);
            if (set.contains(div))
                continue;
            set.add(div);
            backTrack(s, i + 1, end);
            set.remove(div);
        }
    }
}
class Solution3 {
    public int maxProductPath(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int mod = (int) 1e9+7;
        // 表示从起点到i,j的最大正积
        long[][] dp1 = new long[row + 1][col + 1];
        // 表示从起点到i,j的最大负积
        long[][] dp2 = new long[row + 1][col + 1];
        dp1[0][0] = grid[0][0];
        dp2[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            long tmp = (dp1[i - 1][0] * grid[i][0]);
            dp1[i][0] = tmp;
            dp2[i][0] = tmp;
        }
        for (int j = 1; j < col; j++) {
            long tmp = (dp1[0][j - 1] * grid[0][j]);
            dp1[0][j] = tmp;
            dp2[0][j] = tmp;
        }
        for (int i = 1; i < row; i++) {
            for ( int j = 1; j < col; j++) {

                long up1 = (dp2[i - 1][j] * grid[i][j]);
                long left1 = (dp2[i][j - 1] * grid[i][j]);


                long up2 = (dp1[i - 1][j] * grid[i][j]);
                long left2 = (dp1[i][j - 1] * grid[i][j]);
                dp1[i][j] = Math.max(Math.max(up1,up2), Math.max(left1,left2));
                dp2[i][j] = Math.min(Math.min(up1,up2), Math.min(left1,left2));

            }
        }
        return dp1[row-1][col-1] < 0 ? -1 : (int)(dp1[row-1][col-1] % mod);
    }
}
