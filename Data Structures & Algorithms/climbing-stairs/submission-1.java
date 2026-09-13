class Solution {
    Map<Integer, Integer> cache = new HashMap<>();
    {
        cache.put(0, 1);
        cache.put(1, 1);
        cache.put(2, 2);
    }
    public int climbStairs(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            cache.put(n, cache.get(n - 1) + cache.get(n - 2));
            return cache.get(n);
        }
    }
}
