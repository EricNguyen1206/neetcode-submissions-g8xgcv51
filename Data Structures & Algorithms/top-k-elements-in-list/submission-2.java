class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] bucket = new List[n+1];

        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            if (count.get(num) == null) {
                count.put(num, 0);
            }
            count.put(num, count.get(num) + 1);
        }

        for (int num : count.keySet()) {
            if (bucket[count.get(num)] == null) {
                bucket[count.get(num)] = new ArrayList<>();
            }
            bucket[count.get(num)].add(num);
        }

        int[] res = new int[k];
        int idx = 0;

        for (int i = bucket.length - 1; i>=0 && idx < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    res[idx++] = num;
                    if (idx >= k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }
}
