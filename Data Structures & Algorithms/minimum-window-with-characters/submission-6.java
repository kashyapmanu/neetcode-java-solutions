class Solution {
    public String minWindow(String s, String t) {
        /*
        Variables to store the below
        - Min length of the window
        - Min window substring
        */
        int minLength = Integer.MAX_VALUE;
        String result = "";

        // Start scanning for min window i = start of window
        for (int i = 0; i < s.length(); i++) {
            // Hashmap to hold each character in t and its occurance count
            Map<Character, Integer> tMap = new HashMap<>();
            for (char c : t.toCharArray()) {
                tMap.put(c, tMap.getOrDefault(c, 0) + 1);
            }

            // j = end of window. Fix start and grow the end
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (tMap.containsKey(c)) {
                    tMap.put(c, tMap.get(c) - 1);
                    if (tMap.get(c) == 0) {
                        tMap.remove(c);
                    }
                }
                if (tMap.isEmpty() && j - i + 1 < minLength) {
                    minLength = j - i + 1;
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }
}
