//请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配
//是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。 
// 
//
// 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
// 
// Related Topics 动态规划


package editor.cn;
//Java：正则表达式匹配
public class P面试题19ZhengZeBiaoDaShiPiPeiLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题19ZhengZeBiaoDaShiPiPeiLcof().new Solution();
        // TO TEST
        System.out.println(solution.isMatch("aa", "a*"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        if (null == s && null == p)
            return true;
        else if (null == p)
            return false;
        int rows= s.length();
        int columns = p.length();
        // i,j定义为前i,j个字符而不是下标
        boolean[][] dp = new boolean[rows+1][columns+1];
        // TODO base状态 遍历边界
        dp[0][0] = true;
        for(int j=1;j<=columns;j++)
        {
            //p[j-1]为*可以把j-2和j-1处的字符删去，只有[0,j-3]都为true才可以
            //因此dp[j-2]也要为true，才可以说明前j个为true
            if(p.charAt(j-1)=='*'&&dp[0][j-2])
                dp[0][j] = true;
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                    dp[i][j] = dp[i-1][j-1];
                else if (p.charAt(j-1) == '*' && j >= 2) {
                        if (p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.')
                            dp[i][j] = dp[i-1][j] || dp[i][j-1];
                        dp[i][j] = dp[i][j] || dp[i][j-2];
                } else
                    dp[i][j] = false;
            }
        }
        return dp[rows][columns];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}