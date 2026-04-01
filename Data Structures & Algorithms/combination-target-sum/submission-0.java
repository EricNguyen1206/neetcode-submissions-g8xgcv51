class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(nums, target,0, 0, new ArrayList<>(), res);

        return res;
    }

    public void backtrack(int[] nums, int target, int start, int sum, List<Integer> current, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(current));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(nums, target, i, sum+nums[i], current, res);
            current.remove(current.size()-1);
        }
    }
}
