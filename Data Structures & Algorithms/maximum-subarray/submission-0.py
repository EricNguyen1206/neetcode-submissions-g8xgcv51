class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        cur_max = nums[0]
        max_so_far = nums[0]

        for i in range(1, len(nums)):
            cur_max = max(nums[i], cur_max + nums[i])
            max_so_far = max(cur_max, max_so_far)
        
        return max_so_far
        