class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0, right = 0, maxCount = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            maxCount = Math.max(maxCount, freqMap.get(c));
            while (right - left + 1 - maxCount > k) {
                char lc = s.charAt(left);
                freqMap.put(lc, freqMap.get(lc) - 1);
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
