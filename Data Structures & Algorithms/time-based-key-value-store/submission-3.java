class TimeMap {

    private Map<String, List<Pair>> store;

    private static class Pair {
        int timestamp;
        String value;
        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> pairs = store.get(key);
        if (pairs == null) return "";
        int low = 0, high = pairs.size() - 1;
        String value = "";

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (pairs.get(mid).timestamp <= timestamp) {
                value = pairs.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return value;
    }
}
