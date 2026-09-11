class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int area = 0;
        while (left < right) {
            area = Math.max(area, Math.min(heights[left], heights[right]) * (right - left));
            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[right] < heights[left]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return area;
    }
}
