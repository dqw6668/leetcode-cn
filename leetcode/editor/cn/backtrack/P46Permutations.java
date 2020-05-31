//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


package editor.cn.backtrack;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;

//Java：全排列
//Date 2020年5月31日
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
        System.out.println(solution.permute(new int[]{1,2,3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            // 特判
            int len = nums.length;
            List<List<Integer>> res = new LinkedList<>();
            if (len == 0) return res;
            backtrack(nums, res, 0, len);
            return res;
        }

        // 回溯框架
        public void backtrack(int[] nums, List<List<Integer>> ret, int index, int maxIndex) {
            // if结束条件
            if (index == maxIndex - 1) {
                List<Integer> path = new LinkedList<>();
                for (int n :
                        nums) {
                    path.add(n);
                }
                ret.add(path);
                return;
            }
            // for选择
            for (int i = index; i < maxIndex; i++) {
                // 做选择
                swap(nums, index, i);
                // 递归
                backtrack(nums, ret, index+1, maxIndex);
                // 撤销，状态重置
                swap(nums, index, i);
            }
        }

        public void swap(int[] arr, int i, int index) {
            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}