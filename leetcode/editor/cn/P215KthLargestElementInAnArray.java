//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法


package editor.cn;

import java.util.Random;

//Java：数组中的第K个最大元素
public class P215KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(solution.findKthLargest(nums, 4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // 要找第k个数
        int kth = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int res = partition(nums, left, right);
            if (res == kth)
                return nums[res];
            else if (res < kth)
                left = res + 1;
            else
                right = res - 1;
        }
    }

        /**
         * 在数组nums[left..right]中partition寻找下标left排序后正确的位置
         * @param nums
         * @param left
         * @param right
         * @return 返回nums[left]排序后正确的下标
         */
    public int partition(int[] nums, int left, int right) {
        // 考虑极端的情况,pivot需要随机选取
        if (right > left) {
            int randomIndex = new Random().nextInt(right - left) + 1;
            swp(nums, left, left + randomIndex);
        }
        int pivot = nums[left];
        int j = left;
        // nums[left+1..j]的数 < pivot
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot)
                swp(nums, i, ++j);
        }
        // 此时pivot下标为left
        swp(nums, left, j);
        // swp后nums[left..j-1] < pivot  nums[j] = pivot, nums[j+1..right] >= pivot
        return j;
    }

    public void swp(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}