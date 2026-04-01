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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return list1;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = null;
        ListNode node1 = list1;
        ListNode node2 = list2;
        if (node1.val <= node2.val) {
            head = node1;
            node1 = node1.next;
        } else {
            head = node2;
            node2 = node2.next;
        }
        ListNode res = head;

        while (node1 != null && node2 !=null) {
            ListNode temp = head;
            if (node1.val <= node2.val) {
                head.next = node1;
                node1 = node1.next;
            } else {
                head.next = node2;
                node2 = node2.next;
            }
            head = head.next;
        }

        if (node1 != null) {
            head.next = node1;
        } else {
            head.next = node2;
        }

        return res;
    }
}