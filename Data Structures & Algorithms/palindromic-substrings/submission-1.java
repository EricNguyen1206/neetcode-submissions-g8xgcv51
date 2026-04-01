class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        int total = 0;

        for (int i = 0; i<s.length(); i++) {
            int odd = countFromCenter(s, i, i);
            int even = countFromCenter(s, i, i+1);

            total = total + odd + even;
        }

        return total;
    }

    public int countFromCenter(String s, int l, int r) {
        int cnt = 0;
        
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            cnt++;
        }

        return cnt;
    }

}
