//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 671 👎 0


package editor.cn.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//Java：二叉树的中序遍历
public class P94BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    class Solution2 {
        List<Integer> res = new LinkedList();
        public List<Integer> inorderTraversal(TreeNode root) {
            if(root == null) return new LinkedList();;
            inorderTraversal(root.left);
            res.add(root.val);
            inorderTraversal(root.right);
            return res;
        }
    }


    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            List<Integer> res = new LinkedList();
            while (root != null || !stack.isEmpty()) {
                // 没走到底
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}