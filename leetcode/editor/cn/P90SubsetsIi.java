//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 263 👎 0


package editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：子集 II
public class P90SubsetsIi{
    public static void main(String[] args) {
        Solution solution = new P90SubsetsIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
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
                if (i > start && nums[i] == nums[i - 1])
                    continue;
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