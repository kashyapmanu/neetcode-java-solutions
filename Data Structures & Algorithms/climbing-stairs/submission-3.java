class Solution {
    public int climbStairs(int n) {
        int prev = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prev = 0;
                curr = 0;
            } if (i == 1) {
                prev = 0;
                curr = 1;
            } if (i == 2) {
                prev = 1;
                curr = 2;
            }
            prev = prev + curr;
            curr = curr + 1;
        }
        return curr;
    }
}
