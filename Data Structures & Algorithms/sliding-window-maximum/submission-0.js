class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number[]}
     */
    maxSlidingWindow(nums, k) {
        const n = nums.length
        const res = Array(n - k + 1).fill(0)
        const window = Array(k).fill(0)
        for (let i = 0; i<k; i++) {
            window[i] = nums[i]
        }

        for(let i = k; i<n; i++) {
            res[i-k] = Math.max(...window)
            window[i % k] = nums[i]
        }

        res[n-k] = Math.max(...window)

        return res
    }
}
