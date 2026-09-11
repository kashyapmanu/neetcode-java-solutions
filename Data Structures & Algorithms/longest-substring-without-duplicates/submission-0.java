class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (!charMap.containsKey(charArr[right])) {
                charMap.put(charArr[right], right);
                right++;
            } else {
                maxLength = Math.max(maxLength, right - left);
                int index = charMap.get(charArr[right]);
                left = Math.max(left, index + 1);
                charMap.put(charArr[right], right);
                right++;
            }
        }
        return Math.max(maxLength, right - left);
    }
}
