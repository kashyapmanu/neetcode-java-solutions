class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();

        if (s1Length > s2Length) return false;

        // Create the s1 and s2 counters
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Initialize the counters till s1Length
        for (int i = 0; i < s1Length; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        // Check the initial match
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) matches++;
        }

        // Slide the fixed length window through s2
        int l = 0;
        for (int r = s1Length; r < s2Length; r++) {
            if (matches == 26) return true;
            
            // Add item to window
            int idx = s2.charAt(r) - 'a';
            s2Count[idx]++;
            if (s2Count[idx] == s1Count[idx]) matches++;
            if (s2Count[idx] == s1Count[idx] + 1) matches--;

            // Remove item from window
            idx = s2.charAt(l) - 'a';
            s2Count[idx]--;
            if (s2Count[idx] == s1Count[idx]) matches++;
            if (s2Count[idx] == s1Count[idx] - 1) matches--;

            l++;
        }


        return matches == 26;
    }
 
}
