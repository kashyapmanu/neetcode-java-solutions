class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] < mid && target < mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
