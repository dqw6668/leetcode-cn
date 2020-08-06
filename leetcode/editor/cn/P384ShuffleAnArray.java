//打乱一个没有重复元素的数组。 
//
// 
//
// 示例: 
//
// // 以数字集合 1, 2 和 3 初始化数组。
//int[] nums = {1,2,3};
//Solution solution = new Solution(nums);
//
//// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
//solution.shuffle();
//
//// 重设数组到它的初始状态[1,2,3]。
//solution.reset();
//
//// 随机返回数组[1,2,3]打乱后的结果。
//solution.shuffle();
// 
// 👍 85 👎 0


package editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Java：打乱数组
public class P384ShuffleAnArray{
    public static void main(String[] args) {
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<Integer> org = new ArrayList<>();
        int[] cur;
    public Solution(int[] nums) {
        cur = nums;
        for (int num : nums) {
            org.add(num);
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        int[] intArr = org.stream().mapToInt(Integer::intValue).toArray();
        return intArr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < cur.length; i++) {
            int rand = new Random().nextInt(cur.length - i) + i;
            int tmp = cur[i];
            cur[i] = cur[rand];
            cur[rand] = tmp;
        }
        return cur;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}