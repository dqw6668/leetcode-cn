package editor.cn.Weeklycompetition;

import editor.cn.tree.TreeNode;

import java.util.*;

public class Week211 {
    public static void main(String[] args) {
    }
}

class Week211Solution1 {
    public int maxLengthBetweenEqualCharacters(String s) {
        // value 为 char所在的下标
        int res = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (!map.containsKey(tmp))
                map.put(tmp, i);
            else
                res = Math.max(res, i - 1 - map.get(tmp));
        }
        return res;
    }
}

class Week211Solution2 {
}

class Week211Solution3 {
    public int bestTeamScore(int[] scores, int[] ages) {
        if(scores.length == 1)
            return scores[0];

        int[][] arr = new int[scores.length][2];
        for(int i = 0; i < scores.length; i++){
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        Arrays.sort(arr, (o1,o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[1];
        });

        int[] dp = new int[scores.length];
        for(int i = 0; i < scores.length; i++){
            dp[i] = arr[i][1];
        }

        int ans = 0;
        for(int i = 0; i < scores.length; i++) {
            for(int j = 0; j < i; j++) { // 找在i之前有没有比i小的
                if(arr[j][1] <= arr[i][1]) {
                    dp[i] = Math.max(dp[j]+arr[i][1], dp[i]);
                }
                ans = Math.max(ans,dp[i]);
            }
        }
        return ans;
    }
}