class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int fst = nums[0];
        int sec = Math.max(nums[1], fst);

        for (int i = 2; i<nums.length; i++) {
            int max = Math.max(sec, fst + nums[i]);
            fst = sec;
            sec = max;
        }

        return sec;
    }
}
