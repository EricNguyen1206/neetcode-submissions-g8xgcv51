class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int max0 = rob1(nums, 0, n - 1); // exclude last house
        int max1 = rob1(nums, 1, n);     // exclude first house

        return Math.max(max0, max1);
    }

    public int rob1(int[] nums, int start, int end) {
        int prev = nums[start];
        int cur = Math.max(prev, nums[start + 1]);

        for (int i = start + 2; i < end; i++) {
            int tmp = Math.max(cur, prev + nums[i]);
            prev = cur;
            cur = tmp;
        }

        return cur;
    }
}
