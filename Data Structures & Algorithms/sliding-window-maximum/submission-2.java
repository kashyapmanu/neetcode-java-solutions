class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Initialize the necessary variables
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Initialize deque
        Deque<Integer> deque = new ArrayDeque<>();

        // Slide the window through the length of the input
        for (int right = 0; right < n; right++) {
            // Remove the lest most item from the window once window length reached
            while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }

            // As long as first element in window is less than right most element keep polling
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            // Insert the right most element into the window
            deque.offerLast(right);

            // Once valid  window size is reached start storing the results
            if (right >= k - 1) {
                result[right - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
