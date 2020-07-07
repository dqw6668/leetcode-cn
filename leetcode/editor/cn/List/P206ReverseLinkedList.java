//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1068 👎 0


package editor.cn.List;
//Java：反转链表
public class P206ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
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
class Solution {
    public ListNode reverseList(ListNode head) {
        // 特判
        if (null == head || null == head.next)
            return head;
        // 记录上一个节点
        ListNode pre = null;
        // 记录后一个节点
        ListNode next;
        // 循环条件为下一个不为空
        while (null != head.next) {
            // 先保存next
            next = head.next;
            // 反转当前head指向前一个
            head.next = pre;
            // 依次后移
            pre = head;
            head = next;
        }
        // 循环条件为下一个不为空，则最后一个节点还需要处理
        head.next = pre;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}