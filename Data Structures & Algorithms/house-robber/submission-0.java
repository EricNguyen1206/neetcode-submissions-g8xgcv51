class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(nums, 0, dp);
    }

    public int dfs(int[] nums, int i, int[] dp) {
        if (i >= nums.length) return 0;

        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = Math.max(dfs(nums, i+1, dp), nums[i] + dfs(nums, i+2, dp));

        return dp[i];
    }
}
