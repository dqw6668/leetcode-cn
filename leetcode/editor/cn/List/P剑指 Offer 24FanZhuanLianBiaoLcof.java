//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表


package editor.cn.List;

//Java：反转链表
class P24FanZhuanLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new P24FanZhuanLianBiaoLcof().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    /**
     * 明确定义递归，返回反转的链表的头节点，链表尾指向null
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (null == head || null == head.next) return head;
            ListNode res = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}