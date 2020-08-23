package editor.cn.Weeklycompetition;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Five on 2020/8/16 14:51
 */
public class Week202 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        // TO TEST
        System.out.println(solution4.minDays(61455274));
    }
}

class Solution1 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int len = arr.length;
        if (len < 3) return false;
        int count = 0;
        for (int i = 0; i <= len - 3; i++) {
            count = 0;
            for (int j = i; j < i + 3; j++) {
                if ((arr[j] & 1) == 1) count++;
            }
            if (count == 3) return true;
        }
        return false;
    }
}

class Solution4 {
    Map<Integer, Integer> map = new HashMap<>();

    public int minDays(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (map.containsKey(n))
            return map.get(n);
        int res = Math.min(minDays(n / 2) + n % 2 + 1, minDays(n / 3) + n % 3 + 1);
        map.put(n, res);
        return res;
    }
}

class Solution2 {
    public int minOperations(int n) {
        int result = 0;
        int tmp = n - 1;
        while (tmp > 0) {
            result += tmp;
            tmp -= 2;
        }
        return result;
    }
}

class Solution3 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int right = (position[position.length - 1] - position[0]) / (m - 1);
        int left = 1;
        int mid;
        while (left < right) {
            mid = (left + right + 1) >>> 1;
            int cnt = 1; //符合相邻两个点之间的距离>=mid的个数
            int last = position[0];
            for (int i = 1; i < position.length; i++) {
                if (position[i] - last >= mid) {
                    last = position[i];
                    cnt++;
                }
            }
            if (cnt >= m) {
                left = mid;
            }
            else
                right = mid - 1;
        }
        return left;
    }
}
