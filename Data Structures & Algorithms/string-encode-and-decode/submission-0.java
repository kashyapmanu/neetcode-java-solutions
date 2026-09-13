class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int n = str.length();
            sb.append(n).append('@').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(chars[i]) && chars[i + 1] == '@') {
                StringBuilder sb = new StringBuilder();
                for (int j = i + 2; j < Math.min(chars[i], n); j++) {
                    sb.append(chars[j]);
                }
                result.add(sb.toString());
                i += Character.getNumericValue(chars[i]);
            }
        }
        return result;
    }
}
