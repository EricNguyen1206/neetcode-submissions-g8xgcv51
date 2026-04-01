class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];

        for (int i = 1; i<n; i++) {
            int cur = nums[i];
            int tempMax = Math.max(cur, Math.max(cur * maxProd, cur * minProd));
            int tempMin = Math.min(cur, Math.min(cur * maxProd, cur * minProd));

            maxProd = tempMax;
            minProd = tempMin;

            res = Math.max(res, maxProd);
        }

        return res;
    }
}
