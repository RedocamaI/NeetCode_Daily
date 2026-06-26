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

// 0 -> 1 -> 2 -> 6 -> 5 -> 4 -> 3
// 0 -> 1 -> 2 -> 6 -> 5 -> 4

class Solution {
    public int getLength(ListNode node) {
        int n = 0;
        while(node != null) {
            node = node.next;
            n++;
        }

        return n;
    }

    public ListNode getMidNode(ListNode node, int n) {
        int midInd = n/2;

        while(midInd > 1 && node != null) {
            node = node.next;
            midInd--;
        }

        return node;
    }

    public ListNode reverseSecondHalf(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;

        while(cur != null) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode node = head;

        int n = getLength(node);
        if(n >= 0 && n <= 2)
            return;
        
        ListNode mid = getMidNode(head, n);
        ListNode secondHalfStart = mid.next;
        mid.next = null;
        
        ListNode secondHead = reverseSecondHalf(secondHalfStart);
        ListNode p = head;
        ListNode q = secondHead;
        while(p != null && q != null) {
            ListNode pNext = p.next;
            ListNode qNext = q.next;

            p.next = q;
            if(pNext != null)
                q.next = pNext;

            p = pNext;
            q = qNext;
        }
    }
}
