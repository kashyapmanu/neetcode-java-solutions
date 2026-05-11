class Solution {
    public int climbStairs(int n) {
        // The number of ways we need to read a step can be found from knowing the number of ways to
        // read the previous two steps. ̰
        int prev = 1;
        int curr = 2;
        for (int i = 3; i <= n; i++) {
            int temp = prev;
            prev = curr;
            curr = curr + temp;
        }
        return n == 1 ? prev : curr;
    }
}
