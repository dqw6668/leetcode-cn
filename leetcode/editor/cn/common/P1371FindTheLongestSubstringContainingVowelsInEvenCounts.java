//给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "eleetminicoworoep"
//输出：13
//解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcodeisgreat"
//输出：5
//解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
// 
//
// 示例 3： 
//
// 
//输入：s = "bcbcbc"
//输出：6
//解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 x 10^5 
// s 只包含小写英文字母。 
// 
// Related Topics 字符串


package editor.cn.common;

import java.util.Arrays;

//Java：每个元音包含偶数次的最长子字符串
// date 2020年5月20日
public class P1371FindTheLongestSubstringContainingVowelsInEvenCounts {
    public static void main(String[] args) {
        Solution solution = new P1371FindTheLongestSubstringContainingVowelsInEvenCounts().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTheLongestSubstring(String s) {
            char[] arr = s.toCharArray();
            int even = 0b0, max = 0;
            int[] dp = new int[1 << 5];
            Arrays.fill(dp, -1);
            dp[even] = 0;
            for (int i = 0; i < arr.length; i++) {
                char c = arr[i];
                if (c == 'a') even ^= 1;
                else if (c == 'e') even ^= (1 << 1);
                else if (c == 'i') even ^= (1 << 2);
                else if (c == 'o') even ^= (1 << 3);
                else if (c == 'u') even ^= (1 << 4);
                if (dp[even] == -1)
                    dp[even] = i + 1;
                else
                    max = Math.max(max, i - dp[even] + 1);
            }
            return max;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
class Solution2 {
    public int findTheLongestSubstring(String s) {
        /*
            5位二进制的整型[0,31]分别表示5个元音字母出现次数的奇偶
            状态01001表示'a'与'o'出现了奇数次，其他3个元音字母出现了偶数次。
            那么，当状态01001再次出现时，两次出现的下标之间的子串一定是符合要求的子串
            即5个元音字母均出现了偶数次。（任何一个元音字母出现了奇数次都将改变此状态）
            a: 00001
            e: 00010
            i: 00100
            o: 01000
            u: 10000
         */
        //用一个长度为32的数组记录左侧左侧字符状态最小下标。如
        // lelacacd：
        // 00000=-1（左侧全偶数个字符的开始位置为-1）,
        // 00010=1（左侧奇数个e的开始位置为1）,
        // 00011=3（左侧有奇数个e 奇数个a的开始位置为3）
        int[] status = new int[1 << 5];
        Arrays.fill(status, -10);
        status[0] = -1;
        int res = 0;
        int curStatus = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                    curStatus ^= (1 << 0);
                    break;
                case 'e':
                    curStatus ^= (1 << 1);
                    break;
                case 'i':
                    curStatus ^= (1 << 2);
                    break;
                case 'o':
                    curStatus ^= (1 << 3);
                    break;
                case 'u':
                    curStatus ^= (1 << 4);
                    break;
            }
            if (status[curStatus] != -10)
                res = Math.max(res, i - status[curStatus]);
            else
                status[curStatus] = i;
        }
        return res;
    }
}
}