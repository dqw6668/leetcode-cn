//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 334 👎 0


package editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Java：组合
public class P77Combinations{
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList();
        public List<List<Integer>> combine(int n, int k) {
            LinkedList<Integer> comb = new LinkedList<>();
            backTrack(comb, 1, n, k);
            return res;
        }

        private void backTrack(LinkedList<Integer> curComb, int index, int n, int k) {
            if (curComb.size() == k) {
                res.add(new ArrayList<>(curComb));
                return;
            }
            for(int i = index; i <=n; i++) {
                curComb.offerLast(i);
                backTrack(curComb, i + 1, n, k);
                curComb.pollLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}