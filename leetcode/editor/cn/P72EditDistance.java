//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
// Related Topics 字符串 动态规划


package editor.cn;
//Java：编辑距离
public class P72EditDistance{
    public static void main(String[] args) {
        Solution solution = new P72EditDistance().new Solution();
        // TO TEST
        System.out.println(solution.minDistance("i", "execution"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (Math.min(len1, len2) == 0)
            return Math.max(len1, len2);
        // 明确状态i,j,表示word1[0到i]和word2[0到j]需要的最小步数
        int[][] dp = new int[len1+1][len2+1];
        // base状态 注意i,j的定义
        // 这里i,j表示字符串长度，而不是下标，当其中一个长度为0,dp值应该为另一个字符串长度
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 如果字符相同，都后移，长度为1时，下标为0
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    // 增，删，改
                    dp[i][j] = Math.min(
                                Math.min(
                                dp[i-1][j] + 1, // 往i插入一个，从i-1往后移
                                dp[i][j-1] + 1), // 把j删掉
                                dp[i - 1][j - 1] +1);
            }
        }
        return dp[len1][len2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}