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
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        
        ListNode fast = null;
        ListNode slow = head;

        if(head.next != null) {
            if(head.next.next != null) {
                fast = head.next.next;
            }
        }

        while(fast != null && 
        fast.next != null && 
        fast.next.next != null) {
            if(fast == slow)
                return true;
            
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}
