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
    private int getLen(ListNode l) {
        if(l == null)
            return 0;
        
        ListNode cur = l;
        int len = 0;
        while(cur != null) {
            len++;
            cur = cur.next;
        }

        return len;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLen(l1);
        int len2 = getLen(l2);
        ListNode tail1 = l1;
        ListNode tail2 = l2;
        ListNode tail = tail1;

        if(len1 < len2) {
            tail = tail2;
            // swap nodes:
            ListNode node = new ListNode(0);
            node = tail1;
            tail1 = tail2;
            tail2 = node;
        }

        int carry = 0;
        ListNode store = tail1;
        while(tail1 != null && tail2 != null) {
            int val = (tail1.val + tail2.val) + carry;
            carry = val <= 9 ? 0 : 1;
            val = val%10;

            tail1.val = val;
            
            store = tail1;
            tail1 = tail1.next;
            tail2 = tail2.next;
        }

        while(tail1 != null) {
            int val = tail1.val + carry;
            carry = val <= 9 ? 0 : 1;
            val = val%10;

            tail1.val = val;

            store = tail1;
            tail1 = tail1.next;
        }

        if(carry == 1) {
            ListNode node = new ListNode(carry);
            store.next = node;
        }

        return tail;
    }
}
