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
    public ListNode reverseList(ListNode head) {
        ListNode first = head;
        ListNode tail = head;
        while (first!= null && first.next != null) {
            ListNode temp = first.next;
            first.next = temp.next;
            temp.next = tail;
            tail = temp;
        }
        return tail;
    }
}
