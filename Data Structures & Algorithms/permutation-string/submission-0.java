class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        int s1Length = s1.length();
        int s2Length = s2.length();
        for (int i = 0; i < s1Length; i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int matches = 0;
        for (int i = 0; i < s2Length; i++) {
            int j = i;
            while (s1Map.containsKey(s2.charAt(i))) {
                s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
                if (s2Map.get(s2.charAt(i)) == s1Map.get(s2.charAt(i))) {
                    matches++;
                    if (matches == s1Length) return true;
                } else if (s2Map.get(s2.charAt(i)) > s1Map.get(s2.charAt(i))) {
                    s2Map.put(s2.charAt(i), s2Map.get(s2.charAt(i)) - 1);
                    matches--;
                }
                i++;
            }
            if (s2Map.containsKey(s2.charAt(j))) {
                s2Map.put(s2.charAt(j), s2Map.get(s2.charAt(j)) - 1);
                matches--;
            }
            i = j;
        }
        return false;
    }
}
