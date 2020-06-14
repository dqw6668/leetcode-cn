//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表


package editor.cn.common;

//Java：和为K的子数组
public class P560SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new P560SubarraySumEqualsK().new Solution();
        // TO TEST
        System.out.println(solution.subarraySum(new int[]{-1, -1, 1}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            //思路：暴力法，穷举出所有的子数组，比较其和是否和k相等
            int sum = 0;
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                int count = 0;
                for (int j = i; j < len; j++) {
                    count += nums[j];
                    if (count == k) {
                        sum++;
                    }
                }
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}