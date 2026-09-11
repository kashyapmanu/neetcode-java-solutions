class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        int left = 1, right = 1;  
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            left *= nums[i-1];
            result[i] = left;
        }
        for (int j = n - 2; j >= 0; j--) {
            right *= nums[j + 1];
            result[j] *=  right;
        }
        return result;
    }
}
