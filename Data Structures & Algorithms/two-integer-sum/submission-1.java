class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // part -> index

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
