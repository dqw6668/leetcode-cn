//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组 
// 👍 528 👎 0


package editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：合并区间
// date 2020-07-31 20:04
public class P56MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (null == intervals || intervals.length == 0) return new int[0][];
            Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
            List<int[]> tmp = new ArrayList<>();
            for (int i = 0; i < intervals.length - 1; i++) {
                // 可以合并的话
                if (intervals[i][1] >= intervals[i + 1][0]) {
                    intervals[i + 1][0] = intervals[i][0];
                    if (intervals[i][1] > intervals[i + 1][1])
                        intervals[i + 1][1] = intervals[i][1];
                }
                // 否则
                else {
                    tmp.add(intervals[i]);
                }
            }
            // i只到len - 1
            tmp.add(intervals[intervals.length - 1]);
            return tmp.toArray(new int[tmp.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}