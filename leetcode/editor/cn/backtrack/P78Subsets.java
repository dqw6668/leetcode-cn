//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 647 👎 0


package editor.cn.backtrack;

import java.util.ArrayList;
import java.util.List;

//Java：子集
public class P78Subsets{
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            backtrack(0, nums, res, new ArrayList<>());
            return res;
        }

        /***
         *
         * @param start 当前需要添加到子集的数下标
         * @param nums
         * @param res
         * @param curComb 当前子集组合
         */
        public void backtrack(int start, int[] nums, List<List<Integer>> res, List<Integer> curComb) {
            // 将当前子集组合加入结果
            res.add(new ArrayList<>(curComb));
            // 对于所有的选择
            for (int i = start; i < nums.length; i++) {
                // 做选择，将其加入组合
                curComb.add(nums[i]);
                backtrack(i+1, nums, res, curComb);
                // 回溯选择
                curComb.remove(curComb.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}