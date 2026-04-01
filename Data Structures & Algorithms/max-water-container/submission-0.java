class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n-1;
        int maxArea = 0;
        while (left < right) {
            int h = Math.min(heights[left], heights[right]);
            int newArea = (right-left)*h;
            maxArea = Math.max(maxArea, newArea);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
