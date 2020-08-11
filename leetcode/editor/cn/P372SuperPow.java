//你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。 
//
// 示例 1: 
//
// 输入: a = 2, b = [3]
//输出: 8
// 
//
// 示例 2: 
//
// 输入: a = 2, b = [1,0]
//输出: 1024 
// Related Topics 数学 
// 👍 77 👎 0


package editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：超级次方
public class P372SuperPow {
    public static void main(String[] args) {
        // TO TEST
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static final int mod = 1337;

    public int superPow(int a, int[] b) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : b) {
            list.add(i);
        }
        return myPow(a, list);
    }

    private int myPow(int n, LinkedList<Integer> list) {
        if (list.size() == 0)
            return 1;
        Integer last = list.removeLast();
        n = n % mod;
        // 求最低位次方 加上高位，高一位10次方
        int part1 = quickPow(n, last);
        int part2 = quickPow(myPow(n, list), 10);
        return (part1 * part2) % mod;
    }

    /***
     * 计算n的k次方
     * @param n
     * @param k
     * @return n^k
     */
    private int quickPow(int n, Integer k) {
        int res = 1;
        int tmp = n % mod;
        while (k > 0) {
            // 将k的二进制位来求，如果为1则有效位
            if ((k & 1) == 1)
                res = (res * tmp) % mod;
            // 要移位了，所以tmp^2
            tmp = (tmp * tmp) % mod;
            k = k >> 1;
        }
        return res % mod;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

