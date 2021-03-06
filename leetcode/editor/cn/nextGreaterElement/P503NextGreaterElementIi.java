//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈


package editor.cn.nextGreaterElement;

import java.util.Arrays;
import java.util.Stack;

//Java：下一个更大元素 II
public class P503NextGreaterElementIi{
    public static void main(String[] args) {
        Solution solution = new P503NextGreaterElementIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // 寸结果的数组
        int[] res = new int[nums.length];
        // 利用单调栈
        Stack<Integer> stack = new Stack<>();
        // 全初始-1
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * nums.length; i++) {
            // 所有数都要先入栈才能出栈，当找到一个比栈中数大的，那么就是他的下一个更大的元素
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                res[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}