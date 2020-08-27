//给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。 
//
// 注意：1 ≤ k ≤ n ≤ 109。 
//
// 示例 : 
//
// 
//输入:
//n: 13   k: 2
//
//输出:
//10
//
//解释:
//字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
// 👍 148 👎 0


package editor.cn;
//Java：字典序的第K小数字
public class P440KThSmallestInLexicographicalOrder{
    public static void main(String[] args) {
        Solution solution = new P440KThSmallestInLexicographicalOrder().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthNumber(int n, int k) {
        // 从1开始
        int cur = 1;
        k -= 1;
        while (k > 0) {
            int sumNode = getNode(n, cur, cur + 1);
            // 要么往下子节点，要么往右xd节点
            if (sumNode <= k) {
                cur = cur + 1;
                k = k - sumNode;
            }
            else {
                cur = cur * 10;
                k -= 1;
            }
        }
        return cur;
    }

    private int getNode(int maxNode, long start, long end) {
        int cnt = 0;
        while (start <= maxNode) {
            cnt += Math.min(maxNode + 1, end) - start;
            // 往子节点
            start *= 10;
            end *= 10;
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}