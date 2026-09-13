class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Get the length of the two strings 
        int s1Length = s1.length();
        int s2Length = s2.length();

        // Frquency array to store the character count 
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Fill the frequency counter till s1Length
        for (int i = 0; i < s1Length; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Counter to store the matches
        int matches = 0;

        // Check how many matches initially
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) matches++;
        }

        // Initial window check done. Now move the window
        int left = 0;
        for (int right = s1Length; right < s2Length; right++) {
            if (matches == 26) return true;

            int rIdx = s2.charAt(right) - 'a';
            s2Count[rIdx]++;
            if (s2Count[rIdx] == s1Count[rIdx]) matches++;
            if (s2Count[rIdx] == s1Count[rIdx] + 1) matches--;
            
            int lIdx = s2.charAt(left) - 'a';
            s2Count[lIdx]--;
            if (s2Count[lIdx] == s1Count[lIdx]) matches++;
            if (s2Count[lIdx] == s1Count[lIdx] - 1) matches--;
            left++;
        }

        // Final check
        return matches == 26;
    }
}
