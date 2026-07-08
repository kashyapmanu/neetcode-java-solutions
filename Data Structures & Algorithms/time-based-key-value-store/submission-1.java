class TimeMap {
    // We need a key value store - the value is listof timestap and value stored
    // ascending order of timestamp
    private Map<String, List<Pair>> store;

    // Define Pair
    public static class Pair {
        int timestamp;
        String value;
        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
        // Initialize the store
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!store.containsKey(key))
            return "";
        List<Pair> pairs = store.get(key);
        if (pairs.isEmpty())
            return "";
        for (int i = pairs.size() - 1; i >= 0; i--) {
            if (pairs.get(i).timestamp <= timestamp) {
                return pairs.get(i).value;
            }
        }
        return "";
    }
}
