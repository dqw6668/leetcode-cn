package editor.cn.Weeklycompetition;

import editor.cn.tree.TreeNode;

import java.util.*;

public class Week209 {
    public static void main(String[] args) {
        Week209Solution1 solution = new Week209Solution1();
        System.out.println(solution.specialArray(new int[]{3, 5}));
    }
}

class Week209Solution1 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1];
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (isSpecial(mid, nums) == -1) {
                right = mid - 1;
            }
            else {
                left = mid;
            }
        }
        if (isSpecial(left, nums) == 0) return left;
        return -1;
    }
    // -1表示小于n个此时n取大了 1表示大于n个
    private int isSpecial(int n, int[] nums) {
        int len = nums.length;
        if (len < n) return -1;
        else if (n == 0) {
            return nums[len - 1] < n ? 0 : 1;
        }
        else if (len == n) {
            return nums[0] >= n ? 0 : -1;
        }
        else {
            if (nums[len - n] >= n) {
                if (nums[len - n - 1] < n) return 0;
                else return 1;
            }
            else
                return -1;
        }
    }
}
class Week209Solution2 {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        boolean isOdd = true;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            int pre = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                if (isOdd) {
                    if ((cur.val & 1) == 0)
                        return false;
                    if (i != 0 && pre >= cur.val)
                        return false;
                }
                else {
                    if ((cur.val & 1) == 1)
                        return false;
                    if (i != 0 && pre <= cur.val)
                        return false;
                }
                pre = cur.val;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            isOdd = !isOdd;
        }
        return true;
    }
}