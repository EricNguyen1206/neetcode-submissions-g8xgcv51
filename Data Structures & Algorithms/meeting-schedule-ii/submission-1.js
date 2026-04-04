/**
 * Definition of Interval:
 * class Interval {
 *   constructor(start, end) {
 *     this.start = start;
 *     this.end = end;
 *   }
 * }
 */

class Solution {
    /**
     * @param {Interval[]} intervals
     * @returns {number}
     */
    minMeetingRooms(intervals) {
        const n = intervals.length;
        if (n == 0) return 0;

        let res = 0;

        const starts = intervals.map(iv => iv.start).sort((a,b)=>a-b);
        const ends = intervals.map(iv => iv.end).sort((a,b)=>a-b);

        let s = 0;
        let e = 0;

        while (s < n) {
            if (starts[s] < ends[e]) {
                s++;
            } else {
                e++;
            }
            res = Math.max(res, s - e);
        }

        return res;
    }
}
