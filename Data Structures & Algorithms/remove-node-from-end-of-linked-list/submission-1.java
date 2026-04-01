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
        // loop 1 count total node, x=l-n
        int l = 0;
        ListNode first = head;
        while (first!=null) {
            first = first.next;
            l++;
        }
        int x = l-n;
        if (x<0) return head;
        if (x==0) return head.next;
        
        // loop 2 while x>0:total--
        ListNode del = head;
        ListNode prev = null;
        // x=1
        while (del != null && x>0) {
            prev = del;
            del = del.next;
            x--;
        }

        // remove the node
        prev.next = del.next;
        if (del != null) {
            del.next = null;
        }

        return head;
    }
}
