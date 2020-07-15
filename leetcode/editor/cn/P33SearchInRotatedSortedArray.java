//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找 
// 👍 826 👎 0


package editor.cn;

//Java：搜索旋转排序数组
public class P33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new P33SearchInRotatedSortedArray().new Solution();
        // TO TEST
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2},0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int len = nums.length;
            if (len < 1) return -1;
            int left = 0, right = len - 1, mid;
            while (left < right) {
                mid = left + (right - left + 1) / 2;
                // 先根据mid 和left判断 如果left到mid有序
                if (nums[mid] > nums[left]) {
                    // 如果目标再left到mid中
                    if (nums[left] <= target && target <= nums[mid - 1])
                        right = mid - 1;
                    else
                        left = mid;
                }
                // mid在右部分，mid到right是有序的
                else {
                    if (nums[mid] <= target && target <= nums[right])
                        left = mid;
                    else
                        right = mid;
                }
            }
            if (nums[left] == target)
                return left;
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}