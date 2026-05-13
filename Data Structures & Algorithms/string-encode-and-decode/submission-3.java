class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int n = str.length();
            sb.append(String.valueOf(n)).append('@').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = 0;
            StringBuilder sb = new StringBuilder();
            while (chars[i] != '@') {
                sb.append(chars[i]);
                i++;
            }
            m = Integer.valueOf(sb.toString());
            StringBuilder sb1 = new StringBuilder();
            for (int j = i + 1; j <= i + m; j++) {
                sb1.append(chars[j]);
            }
            result.add(sb1.toString());
            i += m;
        }
        return result;
    }
}
