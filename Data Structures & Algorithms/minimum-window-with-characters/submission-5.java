class Solution {
    public String minWindow(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        int minLength = sLength + 1;
        int minIdx = -1;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < tLength; i++) {
            char tChar = t.charAt(i);
            tMap.put(tChar, tMap.getOrDefault(tChar, 0) + 1);
        }

        int formed = 0, required = 0;
        required = tMap.keySet().size();

        int l = 0;
        for (int r = 0; r < sLength; r++) {
            char sChar = s.charAt(r);

            if (tMap.containsKey(sChar)) {
                sMap.put(sChar, sMap.getOrDefault(sChar, 0) + 1);
                if (sMap.get(sChar).equals(tMap.get(sChar))) {
                    formed++;
                }
            }

            while (formed == required) {
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    minIdx = l;
                }

                char lChar = s.charAt(l);
                if (tMap.containsKey(lChar)) {
                    if (sMap.get(lChar).equals(tMap.get(lChar))) {
                        formed--;
                    }
                    sMap.put(lChar, sMap.get(lChar) - 1);
                }
                l++;
            }
        }

        if (minIdx == -1)
            return "";
        else
            return s.substring(minIdx, minIdx + minLength);
    }
}
