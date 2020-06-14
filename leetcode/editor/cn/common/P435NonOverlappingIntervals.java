//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。 
//
// 注意: 
//
// 
// 可以认为区间的终点总是大于它的起点。 
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。 
// 
//
// 示例 1: 
//
// 
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
// Related Topics 贪心算法


package editor.cn.common;

import java.util.Arrays;

//Java：无重叠区间
public class P435NonOverlappingIntervals{
    public static void main(String[] args) {
        Solution solution = new P435NonOverlappingIntervals().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 求出最多不重叠区间个数。其他的就是要去掉的
        if (intervals.length <= 1)
            return 0;
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int[] cur = intervals[0];
        int count = 1;
        for (int[] arr:intervals) {
            if (arr[0] >= cur[1]) {
                count++;
                cur = arr;
            }
        }
        return intervals.length - count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}