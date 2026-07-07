class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 1;

        for (int pile: piles) {
            high = Math.max(high, pile);
        }

        while (low < high) {
            int mid = low  + (high - low) / 2;
            if (canEatWithinWindow(piles, h, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canEatWithinWindow(int[] piles, int h, int k) {
        long hours = 0;
        for (int pile: piles) {
            hours += (long)Math.ceil((double)pile/k);
        }
        return hours <= h;
    }
}
