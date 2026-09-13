class Solution {
    public int rob(int[] nums) {
        return robFrom(nums, 0);
    }

    private int robFrom(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }

        int skip = robFrom(nums, i + 1);
        int rob = nums[i] + robFrom(nums, i + 2);

        return Math.max(skip, rob);
    }
}
