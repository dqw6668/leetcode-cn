//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 307 👎 0


package editor.cn.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：组合总和 II
public class P40CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new P40CombinationSumIi().new Solution();
        // TO TEST
        System.out.println(solution.combinationSum2(new int[]{
                10,1,2,7,6,1,5},8));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> res = new ArrayList<>();
            if (candidates == null || candidates.length == 0 || target < candidates[0])
                return res;
            backtrack(0, target, new ArrayList<>(), candidates, res);
            return res;
        }

        /**
         * 与上一道题回朔完全相同，差的只是一个如何避免重复的问题
         *
         * 这个避免重复当思想是在是太重要了。
         * 这个方法最重要的作用是，可以让同一层级，不出现相同的元素。但是却允许了不同层级之间的重复
         *                   1
         *                  / \
         *                 2   2  这种情况不会发生
         *                /     \
         *               5       5
         *                 例2
         *                   1
         *                  /
         *                 2      这种情况确是允许的
         *                /
         *               2
         * 为何会有这种神奇的效果呢？
         * 首先 cur-1 == cur 是用于判定当前元素是否和之前元素相同的语句。这个语句就能砍掉例1。可是问题来了，如果把所有当前与之前一个元素相同的都砍掉，那么例二的情况也会消失。 因为当第二个2出现的时候，他就和前一个2相同了。
         *
         * 那么如何保留例2呢？
         * 那么就用cur > begin 来避免这种情况，你发现例1中的两个2是处在同一个层级上的，
         * 例2的两个2是处在不同层级上的。在一个for循环中，所有被遍历到的数都是属于一个层级的。我们要让一个层级中，必须出现且只出现一个2，那么就放过第一个出现重复的2，但不放过后面出现的2。第一个出现的2的特点就是 cur == begin. 第二个出现的2 特点是cur > begin.
         * @param target
         * @param curComb
         * @param candidates
         * @param res
         */
        private void backtrack(int start, int target, List<Integer> curComb, int[] candidates, List<List<Integer>> res) {
            // 递归出口
            if (target == 0) {
                res.add(new ArrayList<>(curComb));
                return;
            }
            // 对于所有的选择cur
            for (int cur = start; cur < candidates.length; cur++) {
                if (cur > start && candidates[cur] == candidates[cur - 1])
                    continue;
                // 做选择
                int tmp = target - candidates[cur];
                if (tmp < 0)
                    return;
                else {
                    curComb.add(candidates[cur]);
                    // 一个数只能用一次所以cur+1，并且选 选中的cur的后面的数
                    backtrack(cur + 1, tmp, curComb, candidates, res);
                    // 撤销选择
                    curComb.remove(curComb.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}