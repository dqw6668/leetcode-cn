package editor.cn.Weeklycompetition;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Week209 {
    public static void main(String[] args) {
        Week209Solution1 solution = new Week209Solution1();
        System.out.println(solution.specialArray(new int[]{3, 5}));
    }
}

class Week209Solution1 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1];
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (isSpecial(mid, nums) == -1) {
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }
        if (isSpecial(left, nums) == 0) return left;
        return -1;
    }
    // -1表示小于n个此时n取大了 1表示大于n个
    private int isSpecial(int n, int[] nums) {
        int len = nums.length;
        if (len < n) return -1;
        else if (n == 0) {
            return nums[len - 1] < n ? 0 : 1;
        }
        else if (len == n) {
            return nums[0] >= n ? 0 : -1;
        }
        else {
            if (nums[len - n] >= n) {
                if (nums[len - n - 1] < n) return 0;
                else return 1;
            }
            else
                return -1;
        }
    }
}