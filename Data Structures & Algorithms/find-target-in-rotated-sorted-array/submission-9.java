class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] < nums[mid] && (target < nums[mid] && target >= nums[left])) {
                // Left is sorted and the target is in left
                right = mid - 1;
            } else {
                if (target <= nums[right]) {
                    // Target is in the right half
                    left = mid + 1;
                } else {
                    // Target is not in the right haf
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
