class Solution:
    def canJump(self, nums: List[int]) -> bool:
        cur_pos = nums[0]
        max_so_far = nums[0]

        for i in range(1, len(nums)):
            if max_so_far < i:
                return False
            cur_pos = max(cur_pos, i + nums[i])
            max_so_far = max(cur_pos, max_so_far)
        
        return True
        