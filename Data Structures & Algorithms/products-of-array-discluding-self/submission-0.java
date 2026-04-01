class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int product = 1;
        int zeroCnt = 0;

        for (int num: nums) {
            if (num == 0) {
                zeroCnt++;
            } else {
                product *= num;
            }
        }

        for (int i = 0; i<n; i++) {
            if (zeroCnt > 1) {
                res[i] = 0;
            } else if (zeroCnt == 1) {
                if (nums[i] == 0) {
                    res[i] = product;
                } else {
                    nums[i] = 0;
                }
            } else {
                res[i] = product / nums[i];
            }
        }

        return res;
    }
}  
