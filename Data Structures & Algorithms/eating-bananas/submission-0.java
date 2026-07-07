class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        // Find the max pile.
        int maxPile = 0;
        for (int pile: piles) {
            maxPile = Math.max(maxPile, pile);
        }

        // Simulate eating with every speed in ascending order
        for (int k = 1; k <= maxPile; k++) {
            if (canFinish(piles, k, h)) return k;
        }

        return maxPile;

    }

    private boolean canFinish(int[] piles, int k, int h) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;
        }
        return hours <= h;
    }
}
