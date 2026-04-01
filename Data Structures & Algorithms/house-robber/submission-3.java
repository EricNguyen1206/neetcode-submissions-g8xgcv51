class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int[] db = new int[n];
        db[0] = nums[0];
        db[1] = Math.max(db[0], nums[1]);
        
        for (int i = 2; i<n; i++) {
            db[i] = Math.max(nums[i] + db[i-2], db[i-1]);
        }

        return Math.max(db[n-1], db[n-2]);
    }
}
