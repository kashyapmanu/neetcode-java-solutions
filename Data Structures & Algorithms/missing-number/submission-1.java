class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int eSum = (n) * (n + 1) / 2;
        int aSum = 0;
        for (int num: nums) {
            aSum += num;
        }
        return eSum - aSum;
    }
}
