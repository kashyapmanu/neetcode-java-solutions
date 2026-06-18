class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                // Left is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    // Target is in the sorted half
                    right = mid - 1;
                } else {
                    // Target is not in the sorted half
                    left = mid + 1;
                }
            } else {
                // Left is not sorted
                if (target <= nums[right] && target > nums[mid]) {
                    // Target is in the right half
                    left = mid + 1;
                } else {
                    // TTarget is in the left half
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
