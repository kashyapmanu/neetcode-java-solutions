class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Declare and Initialize variables
        int n = nums.length;
        int[] result = new int[n];

        // Two pass method to find the answer

        // L-R pass
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
            // At each i we have the multiplied value of its left side entities
        }

        // R-L pass
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }

        return result;
    }
}  
