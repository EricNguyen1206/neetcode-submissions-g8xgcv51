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
     * @param {ListNode} list1
     * @param {ListNode} list2
     * @return {ListNode}
     */
    mergeTwoLists(list1: ListNode | null, list2: ListNode | null): ListNode {
        const dum = new ListNode()
        let fst = list1
        let sec = list2
        let cur = dum
        
        if (!fst) return sec
        if (!sec) return fst

        if (fst.val < sec.val) {
            cur.next = fst
            fst = fst.next
        } else {
            cur.next = sec
            sec = sec.next
        }
        cur = cur.next

        while (fst && sec) {
            if (fst.val < sec.val) {
                cur.next = fst
                fst = fst.next
            } else {
                cur.next = sec
                sec = sec.next
            }
            cur = cur.next
        }
        if (fst) {
            cur.next = fst
        }
        if (sec) {
            cur.next = sec
        }

        return dum.next
    }
}
