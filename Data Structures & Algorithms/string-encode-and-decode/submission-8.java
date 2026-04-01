class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<strs.size(); i++) {
            sb.append(strs.get(i).length());
            sb.append('#');
            sb.append(strs.get(i));
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) return new ArrayList<>();

        List<String> res = new ArrayList<>();

        for (int i = 0; i<str.length();) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));
            j++;
            i = j+len;
            res.add(str.substring(j, i));
        }


        return res;
    }
}
