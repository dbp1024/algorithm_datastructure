/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 将前面的所有的连续的等值节点删除
        while (head!=null && head.val==val){
            ListNode delNode = head;
            head=head.next;
            delNode.next=null;
        }
        if (head==null)
            return head;

        // 删除中间的等值节点
        ListNode prev = head;
        while (prev.next!=null){
            if (prev.next.val==val){
                ListNode delNode=prev.next;
                prev.next=delNode.next;
                delNode.next=null;
            }else {
                prev=prev.next;
            }
        }
        return head;
    }
}
