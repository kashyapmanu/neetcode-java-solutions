class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Lengths
        int s1Length = s1.length();
        int s2Length = s2.length();

        // If s1Length is greater than s2Length - return false
        if (s1Length > s2Length) {
            return false;
        }
        
        // Create the integer array to represent s1 and s2
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Initialize the s1Count and s2Count till s1Length;
        for (int i = 0; i < s1Length; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Variable to track the matches
        int matches = 0;

        // Check the matches in the first window
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        // Create a fixed length window and slide it
        int l = 0;
        for (int r = s1Length; r < s2Length; r++) {
            if (matches == 26) {
                return true;
            }

            int rIdx = s2.charAt(r) - 'a';
            s2Count[rIdx]++;
            if (s2Count[rIdx] == s1Count[rIdx]) matches++;
            else if (s2Count[rIdx] == s1Count[rIdx] + 1) matches--;

            int lIdx = s2.charAt(l) - 'a';
            s2Count[lIdx]--;
            if (s2Count[lIdx] == s1Count[lIdx]) matches++;
            else if (s2Count[lIdx] == s1Count[lIdx] - 1) matches--;
            l++;
        }
        return matches == 26;
    }
}
