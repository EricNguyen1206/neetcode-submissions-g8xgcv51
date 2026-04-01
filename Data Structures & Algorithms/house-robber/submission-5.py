class Solution:
    def rob(self, nums: List[int]) -> int:
        n =len(nums)
        if n==0: return 0
        if n==1: return nums[0]
        if n==2: return max(nums[0],nums[1])

        one, two, three = nums[0], nums[1], nums[0] + nums[2]

        for i in range(3, n):
            tmp=three
            three=max(one, two) + nums[i]
            one,two=two,tmp
        
        return max(two,three)

