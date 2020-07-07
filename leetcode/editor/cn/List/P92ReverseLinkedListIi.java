//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 414 👎 0


package editor.cn.List;
//Java：反转链表 II
public class P92ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new P92ReverseLinkedListIi().new Solution();
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m >= n || null == head) return head;
        // dummy用于返回结果
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 记录前一个节点
        ListNode pre = dummy;
        ListNode tmp;
        // 链表的第m个节点，是反转的链表的尾部 ;第m个节点的前一个节点，需要连接反转后的链表的头部
        ListNode mth, mthPre;
        // 让head指向要反转的链表头
        for (int i = 1; i < m; i++) {
            pre = pre.next;
            head = head.next;
        }
        mthPre = pre;
        mth = head;
        // 反转子链表[m..n]
        for (int i = m; i < n; i++) {
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        mth.next = head.next;
        head.next = pre;
        mthPre.next = head;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}