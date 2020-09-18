//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 665 👎 0


package editor.cn;

import java.util.Arrays;

//Java：下一个排列
public class P31NextPermutation{
    public static void main(String[] args) {
        Solution solution = new P31NextPermutation().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
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
                    break;
                }
            }
            Arrays.sort(nums, index + 1, len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}