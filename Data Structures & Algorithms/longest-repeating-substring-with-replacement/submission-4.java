class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, maxLength = 0, maxCount = 0;
        int[] charCount = new int[26];

        for (int right = 0; right < s.length(); right ++) {
            /*
            Create the window and start expanding it.
            Once length - max count of repeated characters becomes more than k
            then start shrinking the window from left while moving the right forward.
            */
            charCount[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);
            if ((right - left + 1) - maxCount > k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
