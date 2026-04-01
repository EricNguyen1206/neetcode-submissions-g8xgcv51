class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 1:
            return 0 if nums[0] == target else -1
        
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = left + (right - left) // 2 # make-sure mid is integer

            if nums[mid] == target:
                return mid
            
            if target < nums[mid]:
                if target >= nums[left] or nums[mid] < nums[right]:
                    right = mid - 1
                else:
                    left = mid + 1
            else: # target > nums[mid]
                if nums[left] <= nums[mid] or target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        
        return -1
        