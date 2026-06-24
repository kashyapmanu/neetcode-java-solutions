class Solution {
    public String minWindow(String s, String t) {
        int required = 0, formed = 0, minIdx = -1, minLength = Integer.MAX_VALUE;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        int sLength = s.length();
        int tLength = t.length();

        // Fill the t map
        for (int i = 0; i < tLength; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        required = tMap.keySet().size();
        int l = 0;
        for (int r = 0; r < sLength; r++) {
            if (tMap.containsKey(s.charAt(r))) {
                sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
                if (sMap.get(s.charAt(r)).equals(tMap.get(s.charAt(r)))) {
                    formed++;
                }
            }
            while (formed == required && l < sLength) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    minIdx = l;
                }
                if (sMap.containsKey(s.charAt(l))) {
                    if (sMap.get(s.charAt(l)).equals(tMap.get(s.charAt(l)))) {
                        formed--;
                    }
                    if (sMap.get(s.charAt(l)) == 0) {
                        sMap.remove(s.charAt(l));
                    } else {
                        sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
                    }
                }
                l++;
            }
        }
        if (minIdx == -1) {
            return "";
        } else {
            return s.substring(minIdx, minIdx + minLength);
        }
    }
}
