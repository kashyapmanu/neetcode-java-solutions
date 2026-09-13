/* Brute force */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            int left = i - 1;
            int right = i + 1;

            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }

            while (right < n && heights[right] >= heights[i]) {
                right++;
            }

            int width = right - left - 1;

            area = Math.max(area, width * heights[i]);
        }

        return area;
    }
}
