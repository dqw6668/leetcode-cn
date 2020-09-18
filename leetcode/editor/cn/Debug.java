package editor.cn;

import java.util.*;
import java.util.concurrent.Executors;

/**
 * Created by Five on 2020/8/27 19:04
 */
public class Debug {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.nextPermutation(new int[]{1,3,2});
    }
}
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = -1;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            Arrays.sort(nums);
            return;
        }
        for (int j = len - 1; j > index; j--) {
            if (nums[j] > nums[index]) {
                int tmp = nums[index];
                nums[index] = nums[j];
                nums[j] = tmp;
            }
        }
        Arrays.sort(nums, index + 1, len);
    }
}

