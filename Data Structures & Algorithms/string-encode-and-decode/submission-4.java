class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.lenght).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length) {
            int j = str.indexOf('#');
            int len = Integer.parseInt(str.subString(i, j));
            result.add(str.subString(j + 1, j + 1 + lenght));
            i = j + 1 + lenght;
        }
        return result;
    }
}
