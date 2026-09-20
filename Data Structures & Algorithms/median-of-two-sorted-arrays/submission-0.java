class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int half = (m + n + 1) / 2;
        int low = 0;
        int high = m;

        while (low < high) {
            int i = (low + high) / 2;
            int j = half - i;

            int min = Integer.MIN_VALUE;
            int max = Integer.MAX_VALUE;

            int left1 = (i == 0) ? min : nums1[i - 1];
            int right1 = (i == m) ? max : nums1[i];
            int left2 = (j == 0) ? min : nums2[j - 1];
            int right2 = (j == n) ? max : nums2[j];

            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                } else {
                    return ((Math.max(left1, left2) + Math.min(right1, right2)) / 2.0);
                }
            } else {
                if (left1 > right2) {
                    high = i - 1;
                } else {
                    low = i + 1;
                }
            }
        }

        return 0.0;
    }
}
