class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int l = 0;
        int maxLen = 0;
        for (int r = 0; r<n; r++) {
            freq[s.charAt(r) - 'A']++;
            int winsz = r-l+1;
            int maxF = getMaxFrequency(freq);

            // don't have enough k number to xpan the winsz
            while (winsz - maxF > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
                winsz = r-l+1;
                maxF =getMaxFrequency(freq);
            }

            maxLen = Math.max(maxLen, winsz);
        }
        return maxLen;
    }

    private int getMaxFrequency(int[] count) {
        int max = 0;
        for (int freq : count) {
            max = Math.max(max, freq);
        }
        return max;
    }
}
