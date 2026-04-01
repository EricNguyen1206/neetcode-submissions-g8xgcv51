class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxLen = 0;

        for (int num : nums) {
            // If num don't have left number
            // It is start of a sequence
            if (!numSet.contains(num-1)) {
                int len = 1;
                int temp = num;
                while (numSet.contains(++temp)) {
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}
