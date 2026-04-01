class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 0; i<n+1; i++) {
            for (String w : wordDict) {
                if (i >= w.length() && dp[i-w.length()]) {
                    if (s.substring(i - w.length(), i).equals(w)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n];
    }
}
