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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l = 0;
        ListNode node = head;
        while(node != null) {
            l++;
            node = node.next;
        }
        if(l == 1)
            return null;

        node = head;
        n = l - n;
        if(n == 0)
            return head.next;
        
        ListNode prev = head;
        ListNode requiredNode = head;
        while(n > 0) {
            prev = requiredNode;
            requiredNode = requiredNode.next;
            n--;
        }

        prev.next = requiredNode.next;
        requiredNode.next = null;

        return head;
    }
}
