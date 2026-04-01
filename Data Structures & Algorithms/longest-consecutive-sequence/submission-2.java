class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;

        for (int num : nums) {
            if (!set.contains(num-1)) { // num is head of sequence
                int cur = num;
                int len = 1;
                while (set.contains(cur+1)) {
                    cur++;
                    len++;
                }
                longest = Math.max(longest, len);
            }
        }

        return longest;
    }
}
