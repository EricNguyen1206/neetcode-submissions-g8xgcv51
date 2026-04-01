class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        Set<Character> dic = new HashSet<>();
        int left = 0;
        int res = 1;
        dic.add(s.charAt(0));
        int i = 1;
        for (; i<n; i++) {
            char c = s.charAt(i);
            while (dic.contains(c)) {
                res = Math.max(res, i-left);
                dic.remove(s.charAt(left));
                left++;
            }
            dic.add(c);
        }
        if (dic.contains(s.charAt(i-1))) {
            res = Math.max(res, i-left);
        }

        return res;
    }
}
