//在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到 100 的玩家，即为胜者。 
//
// 如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？ 
//
// 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。 
//
// 给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳
//赢（假设两位玩家游戏时都表现最佳）？ 
//
// 你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。 
//
// 示例： 
//
// 输入：
//maxChoosableInteger = 10
//desiredTotal = 11
//
//输出：
//false
//
//解释：
//无论第一个玩家选择哪个整数，他都会失败。
//第一个玩家可以选择从 1 到 10 的整数。
//如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
//第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
//同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
// 
// Related Topics 极小化极大 动态规划


package editor.cn.TODO;


import java.util.HashMap;
import java.util.Map;

//Java：我能赢吗
public class P464CanIWin {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.champagneTower(3,1,1));
        System.out.println(solution2.champagneTower(1,1,1));
        System.out.println(solution2.champagneTower(2,1,1));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            return true;
        }
    }

    static class Solution2 {
        public double champagneTower(int poured, int query_row, int query_glass) {
            double res = 0.0;
            double need = (query_row + 1 + 1) * (query_row+1) / 2;
            double preneed = need-query_row-1;
            if (poured > need) return 1.0;
            if (poured < preneed) return res;
            double tmp = poured - preneed;
            int cnt = 1;
            if ((poured & 1) == 1) {
                for (int i = 1; i < (query_row + 1) / 2 + 1; i++) {
                    cnt += 2*i;
                }
                cnt *= 2;
                cnt += (query_row / 2 + 1) * 2;
                double avg = tmp / cnt;
                if (query_glass < query_row / 2 + 1)
                    return avg * (Math.pow(2, query_glass));
                else {
                    return avg * (Math.pow(2, ((query_row ) - query_glass)));
                }
            }
            else {
                for (int i = 1; i <= (query_row ) / 2; i++) {
                    cnt += 2*i;
                }
                cnt *= 2;
                double avg = tmp / cnt;
                if ((query_glass + 1) <= (query_row + 1)/ 2)
                    return avg * (Math.pow(2, query_glass));
                else {
                    return avg * (Math.pow(2, ((query_row) - query_glass)));
                }
            }
        }
    }

    }