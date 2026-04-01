from bisect import bisect_left
class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp = []
        dp.append(nums[0]) # dp[i] store the biggest number in sequence 0-i
        
        LIS = 1
        for i in range(1, n):
            if nums[i] > dp[-1]:
                dp.append(nums[i])
                LIS += 1
                continue
            
            idx = bisect_left(dp, nums[i])
            dp[idx] = nums[i]

        return LIS


        