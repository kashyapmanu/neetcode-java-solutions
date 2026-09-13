class Solution {
    public int trap(int[] height) {
        /*
        Iterate through each bar. Find out the leftmost and rightmost heighest bar next to it
        including iteself. If it is the highest then it cant store any water. The bar can store
        somewater between itself and left or right lowest. We are going to do this from left to
        right.
        */
        int n = height.length, total = 0;
        // Iterate  through each of the walls/bars
        for (int i = 0; i < n; i++) {
            // Declare variables that will hold the highest wall for each iteration.
            int leftMax = 0, rightMax = 0;

            for (int l = 0; l <= i; l++) {
                leftMax = Math.max(leftMax, height[l]);
            }
            for (int r = i; r < n; r++) {
                rightMax = Math.max(rightMax, height[r]);
            }

            total += Math.min(leftMax, rightMax) - height[i];
        }

        return total;
    }
}
