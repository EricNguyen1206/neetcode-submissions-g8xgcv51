class Solution {
    /**
        Time O(n): 1 for loop with nums size n
        Space O(n): worse case nums contain all distince digit 
    */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i<nums.length; i++) {
            int part = target - nums[i];
            if (map.containsKey(part)) {
                return new int[]{map.get(part), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
