package editor.cn.Weeklycompetition;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Five on 2020/8/23 18:54
 */
public class DoubleWeek33 {
    public static void main(String[] args) {

    }
}
class DoubleWeek33Solution1 {
    public String thousandSeparator(int n) {
        StringBuffer sb = new StringBuffer(new Integer(n).toString());
        int len = sb.length();
        if (len <= 3)
            return sb.toString();
        int c = len % 3;
        for (int i = len - 1; i > 0; i--) {
            if ((i - c) % 3 == 0 ) {
                sb.insert(i, ".");
            }
        }
        return sb.toString();
    }
}
class DoubleWeek33Solution2{
    /**
     * 如果图中有一条a->b的边，那么b一定不会在最小的点集中，因为b能到达的点a也一定能到达，且a还能比b多到达一个点（a自己），选b不如选a。因此，只有入度为0的点才可能在最小点集中。
     * 最小点集中必须包括所有入度为0的点，假如某个入度为0的点a不在最小点集中，那么最小点集中的其他点一定无法访问到a点，不符合最小点集能到达图中所有点的要求。
     * 由于题目保证解存在且唯一，因此最小点集为图中所有入度为0的点
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] cnt = new int[n];
        List<Integer> res = new LinkedList<>();
        for (List<Integer> list : edges) {
            cnt[list.get(1)]++;
        }
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0)
                res.add(i);
        }
        return res;
    }
}

/**
 * 二进制位得所有1只能一次一次加上去，再加上最多次移位得次数
 */
class DoubleWeek33Solution3{
    public int minOperations(int[] nums) {
        // 二进制位1的统计
        int binaryCnt = 0;
        int movedCnt = 0;
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            while (num != 0) {
                if ((num & 1) == 1)
                    binaryCnt++;
                num = num >> 1;
            }
        }
        while (maxNum != 0) {
            maxNum = maxNum >> 1;
            movedCnt++;
        }
        return movedCnt + binaryCnt - 1;
    }
}
