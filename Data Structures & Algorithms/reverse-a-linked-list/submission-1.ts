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
     * @return {ListNode}
     */
    reverseList(head: ListNode | null): ListNode {
        const dum = new ListNode()
        dum.next = head
        let cur = head;

        while (cur && cur.next) {
            let sec = cur.next
            cur.next = sec.next
            sec.next = dum.next
            dum.next = sec
        }

        return dum.next
    }
}

/**
 * Space: O(1)
 * Time: O(n)
 * 
 * Dry run:
 * head = [0, 1, 2, 3], dum.next = 0, cur = 0
 * sec  | cur.next  | cur   | sec.next  | dum.next  | head
 * 1    | 2         | 2     | 0         | 1         | 1, 0, 2, 3
 * 3    | 
 * 
 */
