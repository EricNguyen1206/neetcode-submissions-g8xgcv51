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
        if (head == null || head.next == null) {
            return false;
        }
        ListNode first = head, sec = head.next;
        while(sec.next != null && sec.next.next != null) {
            first = first.next;
            sec = sec.next.next;
            if (first.val == sec.val) return true;
        }

        return false;
    }
}
