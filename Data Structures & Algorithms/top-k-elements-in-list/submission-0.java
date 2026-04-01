class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        List<int[]> bucket = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            bucket.add(new int[]{entry.getKey(), entry.getValue()});
        }

        bucket.sort((a, b) -> b[1] - a[1]);

        int[] res = new int[k];
        for (int i = 0; i<k; i++) {
            res[i] = bucket.get(i)[0];
        }
        return res;
    }
}
