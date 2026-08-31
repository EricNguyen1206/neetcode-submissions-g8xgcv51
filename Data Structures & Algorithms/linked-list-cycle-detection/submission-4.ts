/**
 * Definition for singly-linked list.
 * class ListNode {
 *     constructor(val = 0, next = null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    /**
     * @param {ListNode} head
     * @return {boolean}
     */
    hasCycle(head: ListNode | null): boolean {
        let fast = head;
        let slow = head;

        while (slow && slow.next && fast && fast.next) {
            slow = slow.next
            fast = fast.next.next
            
            if (slow == fast) return true
        }

        return false
    }


}
