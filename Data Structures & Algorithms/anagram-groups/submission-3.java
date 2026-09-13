class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            String key = new String(Arrays.sort(charArray));
            result.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return result;
    }
}
