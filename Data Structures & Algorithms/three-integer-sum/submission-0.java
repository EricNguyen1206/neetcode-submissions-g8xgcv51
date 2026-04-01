class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, List<int[]>> part = new HashMap<>();
        int n = nums.length;

        // Store all pairs by their sum
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                List<int[]> pairs = part.getOrDefault(sum, new ArrayList<>());
                pairs.add(new int[]{i, j});
                part.put(sum, pairs);
            }
        }

        Set<List<Integer>> resultSet = new HashSet<>();

        // For each element, look for pairs that sum to -nums[i]
        for (int i = 0; i < n; i++) {
            int target = -nums[i];
            if (part.containsKey(target)) {
                for (int[] pair : part.get(target)) {
                    if (pair[0] != i && pair[1] != i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[pair[0]], nums[pair[1]]);
                        Collections.sort(triplet); // to avoid permutation duplicates
                        resultSet.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(resultSet);
    }
}
