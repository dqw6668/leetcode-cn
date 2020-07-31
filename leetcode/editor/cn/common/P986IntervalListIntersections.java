//给定两个由一些 闭区间 组成的列表，每个区间列表都是成对不相交的，并且已经排序。 
//
// 返回这两个区间列表的交集。 
//
// （形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b。两个闭区间的交集是一组实数，要么为空集，要么为闭区间
//。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3]。） 
//
// 
//
// 示例： 
//
// 
//
// 输入：A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
//输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length < 1000 
// 0 <= B.length < 1000 
// 0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9 
// 
// Related Topics 双指针 
// 👍 67 👎 0


package editor.cn.common;

import java.util.ArrayList;
import java.util.List;

//Java：区间列表的交集
public class P986IntervalListIntersections{
    public static void main(String[] args) {
        Solution solution = new P986IntervalListIntersections().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (null == A || null == B || A.length == 0 || B.length == 0)
            return new int[0][];
        List<int[]> tmp = new ArrayList<>();
        int lenA = A.length;
        int lenB = B.length;
        int indexA = 0, indexB = 0;
        while (indexA < lenA && indexB < lenB) {
            // 相交
            if (A[indexA][1] >= B[indexB][0] && A[indexA][0] <= B[indexB][1]) {
                tmp.add(new int[]{Math.max(A[indexA][0], B[indexB][0]), Math.min(A[indexA][1], B[indexB][1])});
            }
            if (A[indexA][1] > B[indexB][1])
                indexB++;
            else
                indexA++;
        }
        return tmp.toArray(new int[tmp.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}