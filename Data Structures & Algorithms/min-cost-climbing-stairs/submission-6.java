class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int onePrev = cost[n - 1];
        int twoPrev = cost[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            int temp = onePrev;
            onePrev = twoPrev;
            twoPrev = cost[i] + Math.min(temp, onePrev);
        }
        return onePrev < twoPrev ? onePrev : twoPrev;
    }
}
