//假设你有一个特殊的键盘包含下面的按键：
//
//        Key 1: (A)：在屏幕上打印一个 'A'。
//
//        Key 2: (Ctrl-A)：选中整个屏幕。
//
//        Key 3: (Ctrl-C)：复制选中区域到缓冲区。
//
//        Key 4: (Ctrl-V)：将缓冲区内容输出到上次输入的结束位置，并显示在屏幕上。
//
//        现在，你只可以按键 N 次（使用上述四种按键），请问屏幕上最多可以显示几个 'A'呢？
//
//        样例 1:
//
//        输入: N = 3
//        输出: 3
//        解释:
//        我们最多可以在屏幕上显示三个'A'通过如下顺序按键：
//        A, A, A
//         
//
//        样例 2:
//
//        输入: N = 7
//        输出: 9
//        解释:
//        我们最多可以在屏幕上显示九个'A'通过如下顺序按键：
//        A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
//         
//
//        注释:
//
//        1 <= N <= 50
//        结果不会超过 32 位有符号整数范围。


package editor.cn.common;

//Java： 4键键盘
public class P651sijianjianpan {
    public static void main(String[] args) {
        Solution solution = new P651sijianjianpan().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxA(int N) {
            // 全选复制粘贴，这里需要消耗三个按键次数
            if (N <= 6) return N;
            // 定义dp数组，dp[i]表示剩余按键次数i时的最多A
            int[] dp = new int[N + 1];
            // 填表，遍历所有按键次数i,ret = dp[N];
            for (int i = 1; i <= N; i++) {
                // 按一个A
                dp[i] = dp[i - 1] + 1;
                // 遍历按粘贴得到A的数量,需要先全选和复制,j表示从第j次以后按粘贴,最多不能等于i，等于i相当于粘贴0次
                for (int j = 2; j < i; j++) {
                    // 粘贴了i - j次，还需要加上原本的A
                    dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
                }
            }
            return dp[N];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}