class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int part = target - nums[i];
            if (seen.containsKey(part)) {
                return new int[]{seen.get(part), i};
            }
            seen.put(nums[i], i);
        }

        return new int[]{};
    }
}
