class Solution {
    public int rob(int[] nums) {
        int oneHBack = 0, twoHBack = 0;

        for (int num: nums) {
            int current = Math.max(oneHBack, twoHBack + num);
            twoHBack = oneHBack;
            oneHBack = current;
        }

        return oneHBack;
    }
}
