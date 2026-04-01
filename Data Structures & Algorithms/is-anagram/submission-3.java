class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();

        if (t.length() != n) return false;

        int[] count = new int[26];
        
        for (int i = 0; i<n; i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int j = 0; j<26; j++) {
            if (count[j] != 0) return false;
        }

        return true;
    }
}
