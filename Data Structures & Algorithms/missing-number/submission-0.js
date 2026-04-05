class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    missingNumber(nums) {
        let res = nums.length; // start with n
        for (let i = 0; i < nums.length; i++) {
            // XOR i and val num
            res ^= i ^ nums[i];
        }
        return res;
    }
}
