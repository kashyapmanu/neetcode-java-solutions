/* Optimal */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= curr) {
                // Finding the right limiter
                int height = heights[stack.pop()];
                int right = i;
                int left = stack.peek() == null ? -1 : stack.peek();
                int width = right - left - 1;
                area = Math.max(area, width * height);
            }
            stack.push(i);
        }
        return area;
    }
}
