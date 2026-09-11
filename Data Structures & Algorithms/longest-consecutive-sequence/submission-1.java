class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int counter = 1;
                int length = 1;
                while (set.contains(num + length)) {
                    counter += 1;
                    length += 1;
                }
                maxLen = Math.max(maxLen, counter);
            }
        }
        return maxLen;
    }
}
