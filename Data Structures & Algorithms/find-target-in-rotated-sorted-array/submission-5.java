class Solution {
    /**
        cmflx:
        tms Ologn
        spx O1
    */
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (nums[m] == target) return m;

            // if the left side was sorted
            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) {
                    r = m-1;
                } else {
                    l = m+1;
                }
            } else { // the right side was sorted
                if (nums[m] < target && target <= nums[r]) {
                    l = m+1;
                } else {
                    r = m-1;
                }
            }
            
        }

        return -1;
    }
    /** dryrun
        tc1: [3,5,6,0,1,2], t=1
        0: l=0, r=5, m=2
        1: l=3, r=5, m=4 => return4

        tc2: [3,5,6,0,1,2], t=4
        0: l=0, r=5, m=2 => 6>4 3<4
        1: l=0 r=1, m=0 => 5>4 3<4
        2: l=0 r=0, m=0 => 3<4
        3: l=1 => break
        return -1

        tc3: [4,5,6,7,0,1,2], t=0
        0: l=0 r=6 m=3 => 7>0 4>0
        1: l=4 r=6 m=5 => 1>0 0=0
        2: l=4 r=4 m=4 => 0=0 return

        tc4: [5,1,3], t=5
    */
}
