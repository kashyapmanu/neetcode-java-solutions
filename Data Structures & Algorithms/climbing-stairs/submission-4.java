class Solution {
    public int climbStairs(int n) {
        int prev, curr;
        prev = 1;
        curr = 2;
        for (int i = 3; i <= n; i++) {
            int temp = prev;
            prev = curr;
            curr = temp + curr;
        }
        return curr;
    }
}
