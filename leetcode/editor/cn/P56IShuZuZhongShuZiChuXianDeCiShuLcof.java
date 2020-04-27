//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums <= 10000 
// 
//
// 
//


package editor.cn;
//Java：数组中数字出现的次数
public class P56IShuZuZhongShuZiChuXianDeCiShuLcof{
    public static void main(String[] args) {
        Solution solution = new P56IShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        int[] res = new int[2];
        for (int num :
                nums) {
            xor ^= num;
        }
        int flag = xor & (-xor);
        for (int num :
                nums) {
            if ((flag & num) == 0)
                res[0] ^= num;
            else
                res[1] ^= num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}