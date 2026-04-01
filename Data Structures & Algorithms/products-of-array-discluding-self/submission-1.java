class Solution {
    /**
        inp: 1, 2, 4, 6
        pre: 1, 1, 2, 8
        post:         6

    */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        int postfix = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (j != nums.length - 1) {
                res[j] *= postfix;
            }
            postfix *= nums[j]; 
        }

        return res;
    }
}  
