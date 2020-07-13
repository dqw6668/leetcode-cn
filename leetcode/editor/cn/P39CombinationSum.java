//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 757 👎 0


package editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：组合总和
public class P39CombinationSum {
    public static void main(String[] args) {
        Solution solution = new P39CombinationSum().new Solution();
        // TO TEST
        System.out.println(solution.combinationSum(new int[]{2,3,6,7}, 7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> res = new ArrayList<>();
            if (candidates == null || candidates.length == 0 || target < candidates[0])
                return res;
            backtrack(target, new ArrayList<>(), candidates, res);
            return res;
        }

        private void backtrack(int target, List<Integer> curComb, int[] candidates, List<List<Integer>> res) {
            // 对于所有的选择
            for (int i = 0; i < candidates.length ;i++) {
                if (target < candidates[i])
                    return;
                else if (target == candidates[i]) {
                    curComb.add(candidates[i]);
                    res.add(new ArrayList<>(curComb));
                    curComb.remove(curComb.size() - 1);
                }
                else {
                    curComb.add(candidates[i]);
                    // 已经从第i个开始选了，就不再选i前面的了，避免重复
                    backtrack(target - candidates[i], curComb, Arrays.copyOfRange(candidates, i,candidates.length), res);
                    curComb.remove(curComb.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}