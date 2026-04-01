class Solution {
    /** 
        Time O(N): 1 for loop
        Space worse case O(N): 1 Map with nums contain all distince values
    */
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i<nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                return true;
            }

            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        return false;
    }
}