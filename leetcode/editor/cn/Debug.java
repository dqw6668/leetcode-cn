package editor.cn;

import java.util.*;
import editor.cn.tree.TreeNode;
/**
 * Created by Five on 2020/8/27 19:04
 */
public class Debug {
    public static void main(String[] args) {
        Solution solution = new Solution();
        LinkedList l = new LinkedList();
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                if (flag)
                    // add加list末尾
                    list.add(node.val);
                else
                    list.push(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            res.add(list);
            flag = !flag;
        }
        return res;
    }
}