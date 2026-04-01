class Solution:
    def rob(self, nums: List[int]) -> int:
        def rob1(nums: List[int]) -> int:
            n = len(nums)
            match n:
                case 0:
                    return 0
                case 1:
                    return nums[0]
                case 2:
                    return max(nums[0], nums[1])
            one, two, three = nums[0], nums[1], nums[2] + nums[0]

            for i in range(3, n):
                tmp = three
                three = max(one, two) + nums[i]
                one = two
                two = tmp

            return max(two, three)
        
        n = len(nums)

        if n < 3:
            return rob1(nums)
        else:
            return max(rob1(nums[:n-1]), rob1(nums[1:]))
