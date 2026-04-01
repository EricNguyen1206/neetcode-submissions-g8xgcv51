class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        cache = {} # val -> index

        for i in range(len(nums)):
            val = target - nums[i]
            if val in cache:
                return [cache[val], i]
            cache[nums[i]] = i

        return []
        