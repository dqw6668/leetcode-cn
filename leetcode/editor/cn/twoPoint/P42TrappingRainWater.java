//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 1543 👎 0


package editor.cn.twoPoint;
//Java：接雨水
public class P42TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        // TO TEST
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * water[i] = min(
     *                # 左边最高的柱子
     *                max(height[0..i]),
     *                # 右边最高的柱子
     *                max(height[i..end])
     *             ) - height[i]
     * 在i位置能接的水等于左右最高高度中小的减去i的高度
     */
    class Solution {
        public int trap(int[] height) {
            if (height == null) return 0;
            int len = height.length;
            if (len == 0) return 0;
            // 使用双指针
            int left = 0, right = len - 1;
            // 记录左边最高柱子 和 右边最高柱子
            int lMax = height[0], rMax = height[len - 1];
            int res = 0;
            int tmp = 0;
            while (left <= right) {
                if (lMax < rMax) {
                    lMax = Math.max(lMax, height[left]);
                    tmp = Math.min(lMax, rMax) - height[left++];
                } else {
                    rMax = Math.max(rMax, height[right]);
                    tmp = Math.min(lMax, rMax) - height[right--];
                }
                res += tmp > 0 ? tmp : 0;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}