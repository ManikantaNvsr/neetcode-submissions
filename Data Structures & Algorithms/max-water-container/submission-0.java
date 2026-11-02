class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(heights[left], heights[right]));
            if (heights[left] > heights[right]) {
                while (heights[right - 1] < heights[right]) {
                    right--;
                }
                right--;
            } else {
                while (heights[left] > heights[left + 1]) {
                    left++;
                }
                left++;
            }
        }
        return maxArea;
    }
}
