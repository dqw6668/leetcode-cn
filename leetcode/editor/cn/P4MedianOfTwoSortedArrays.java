//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。 
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法


package editor.cn;
//Java：寻找两个有序数组的中位数
public class P4MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int m = nums2.length;
            int left = (n + m + 1) / 2;
            int right = (n + m + 2) / 2;
            return (findKthNum(0, n - 1, nums1, 0, m - 1, nums2, left)
                    + findKthNum(0, n - 1, nums1, 0, m - 1, nums2, right))
                    * 0.5;
        }

        private int findKthNum(int start1, int end1, int[] nums1, int start2, int end2, int[] nums2, int k) {
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            if (len1 > len2) {
                return findKthNum(start2, end2, nums2, start1, end1, nums1, k);
            }
            if (len1 == 0)
                return nums2[start2 + k - 1];
            if (k == 1)
                return Math.min(nums1[start1], nums2[start2]);
            int i = start1 + Math.min(len1, k / 2) - 1;
            int j = start2 + Math.min(len2, k / 2) - 1;
            int nums1Kth = nums1[i];
            int nums2Kth = nums2[j];
            if (nums1Kth > nums2Kth)
                return findKthNum(start1, end1, nums1, j + 1, end2, nums2, k - (j - start2 + 1));
            else
                return findKthNum(i + 1, end1, nums1, start2, end2, nums2, k - (i - start1 + 1));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}