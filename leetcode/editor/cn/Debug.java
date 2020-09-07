package editor.cn;

import java.util.*;
import editor.cn.tree.TreeNode;
/**
 * Created by Five on 2020/8/27 19:04
 */
public class Debug {
    public static void main(String[] args) {
        Solution solution = new Solution();
        LinkedList l = new LinkedList();
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len ; i++) {
            for (int j = i + 1; j < len; j++) {
                if (map.containsKey(0 - nums[i] - nums[j])) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(0 - nums[i] - nums[j]);
                    tmp.sort(Comparator.naturalOrder());
                    set.add(tmp);
                }
            }
            map.put(nums[i], i);
        }
        return new ArrayList<>(set);
    }
}