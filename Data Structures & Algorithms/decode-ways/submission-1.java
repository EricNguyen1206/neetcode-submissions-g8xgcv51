class Solution {
    public int numDecodings(String s) {
        if (s == null || s == "" || s.charAt(0) == '0') return 0;

        int n = s.length();
        int prev = 1;
        int cur = 1;

        for (int i = 1; i<s.length(); i++) {
            int tmp = 0;
            if (s.charAt(i) != '0') {
                tmp = cur;
            }

            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                tmp += prev;
            }
            
            prev = cur;
            cur = tmp;
        }

        return cur;
    }
}
