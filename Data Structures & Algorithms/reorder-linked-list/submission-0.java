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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode mid = head;
        ListNode first = head;
        ListNode prevMid = head;
        // find the middle node
        while (first != null && first.next != null) {
            prevMid = mid;
            mid = mid.next;
            first = first.next.next;
        }
        prevMid.next = null;
        ListNode last = reverse(mid);
        merge2List(head, last);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur != null && next != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public void merge2List(ListNode fst, ListNode sec) {
        while (fst != null && sec != null) {
            ListNode temp1 = fst.next;
            ListNode temp2 = sec.next;

            fst.next = sec;
            if (temp1 == null) break;
            sec.next = temp1;
            
            fst = temp1;
            sec = temp2;
        }

    }
}
