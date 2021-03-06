//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window


package editor.cn.nextGreaterElement;

import java.util.ArrayDeque;

//Java：滑动窗口最大值
public class P239SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new P239SlidingWindowMaximum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            // 其中一个为0
            if (len * k == 0) return null;
            // 滑动窗口为1的话
            if (k == 1) return nums;
            // 使用双端队列 存的是下标
            ArrayDeque<Integer> deq = new ArrayDeque<>();
            int[] res = new int[len - k + 1];
            // 初始出滑动窗口
            for (int i = 0; i < k; i++) {
                // 保证deq中按从大到小排列 first肯定是最大的
                while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
                    deq.removeLast();
                }
                deq.addLast(i);
            }
            res[0] = nums[deq.getFirst()];
            // 窗口向右滑动
            for (int i = k; i < len; i++) {
                // 保证deq中的数在滑动窗口中
                if (!deq.isEmpty() && deq.getFirst() == i - k)
                    deq.removeFirst();
                // 保证deq中按从大到小排列 first肯定是最大的
                while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
                    deq.removeLast();
                }
                deq.addLast(i);
                res[i - k + 1] = nums[deq.getFirst()];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}