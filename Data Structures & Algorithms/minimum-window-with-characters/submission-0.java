class Solution {
    public String minWindow(String s, String t) {
        int required = 0, formed = 0, minIdx = 0, maxIdx = 0;
        
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
                if (sMap.get(s.charAt(r)) == tMap.get(s.charAt(r))) {
                    formed++;
                }
            }
            while (formed == required) {
                minIdx = l;
                maxIdx = r;
                if (sMap.containsKey(s.charAt(l))) {
                    if (sMap.get(s.charAt(l)) == 0) {
                        sMap.remove(s.charAt(l));
                    } else {
                        sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
                    }
                    formed--;
                }
                l++;
            }
        }
        if (minIdx == 0 && maxIdx == 0) {
            return "";
        } else {
            return s.substring(minIdx, maxIdx + 1);
        }
    }
}
