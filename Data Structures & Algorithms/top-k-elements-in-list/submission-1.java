class Solution {
    /**
        Approach: Bucket sort
        TC: O(nlogn); SC: O(2n) => n = nums lenght
    */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int num : count.keySet()) {
            int f = count.get(num);
            if (bucket[f] == null) {
                bucket[f] = new ArrayList<>();
            }
            bucket[f].add(num);
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = bucket.length - 1; i>=0 && idx<k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    res[idx++] = num;
                    if (idx >= k) return res;
                }
            }
        }

        return res;
    }
}
