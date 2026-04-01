class Solution {
    /**
        Time O(n) + 26: 1 loop for string len
        Space O(26): array with fixed size - 26
    */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];
        
        for (int i = 0; i<s.length(); i++) {
            int c1 = s.charAt(i) - 'a';
            int c2 = t.charAt(i) - 'a';
            freq[c1]++;
            freq[c2]--;
        }

        for (int i = 0; i<26; i++) {
            if (freq[i] != 0) return false;
        }

        return true;
    }
}
