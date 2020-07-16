//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 505 👎 0


package editor.cn.binarySearch;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[]{-1,-1};
            int len = nums.length;
            if (len < 1 || nums[0] > target || nums[len - 1] < target)
                return res;
            // 找target的起始位置
            int left = 0, right = len - 1, mid;
            while (left < right) {
                mid = left + (right - left) / 2;
                // mid分到左边
                if (nums[mid] < target)
                    left = mid + 1;
                // nums[mid] >= target意味着找到了后半部分的target，这里要找起始位置
                else
                    right = mid;
            }
            if (nums[left] == target)
                res[0] = left;

            // 找target的终止位置
            left = 0;
            right = len - 1;
            while (left < right) {
                mid = left + (right - left + 1) / 2;
                // mid分到右边 ,取右中位数
                if (nums[mid] > target)
                    right = mid - 1;
                    // nums[mid] <=> target意味着找到了前半部分的target，这里要找终止位置
                else
                    left = mid;
            }
            if (res[0] != -1)
                res[1] = left;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}