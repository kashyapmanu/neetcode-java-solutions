class Solution {
    public String minWindow(String s, String t) {
        int sLength = s.length(), tLength = t.length();
        int minLength = Integer.MAX_VALUE, minIdx = -1;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        int required = 0, formed = 0;

        for (int i = 0; i < tLength; i++) {
            char tChar = t.charAt(i);
            tMap.put(tChar, tMap.getOrDefault(tChar, 0) + 1);
        }

        required = tMap.size();

        int l = 0, r = 0;

        for (r = 0; r < s.length(); r++) {
            
            char rChar = s.charAt(r);
            
            if (tMap.containsKey(rChar)) {
                sMap.put(rChar, sMap.getOrDefault(rChar, 0) + 1);
                if (sMap.get(rChar) == tMap.get(rChar)) {
                    formed++;
                }
            }

            while (formed == required) {
                int winLength = r - l + 1;
                if (winLength < minLength) {
                    minLength = winLength;
                    minIdx = l;
                }
                char lChar = s.charAt(l);
                if (tMap.containsKey(lChar)) {
                    if (sMap.get(lChar) == tMap.get(lChar)) {
                        formed--;
                    }
                    sMap.put(lChar, sMap.get(lChar) - 1);
                }
                l++;
            }
        }

        return minIdx == -1 ? "" : s.substring(minIdx, minIdx + minLength);
    }
}
