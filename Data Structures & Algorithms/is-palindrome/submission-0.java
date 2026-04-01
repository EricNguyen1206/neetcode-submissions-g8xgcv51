class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            char cl = Character.toLowerCase(s.charAt(left));
            char cr = Character.toLowerCase(s.charAt(right));
            while (left < right && !Character.isLetterOrDigit(cl)) {
                left++;
                cl = Character.toLowerCase(s.charAt(left));
            }
            while (left < right && !Character.isLetterOrDigit(cr)) {
                right--;
                cr = Character.toLowerCase(s.charAt(right));
            }
            if (cr != cl) return false;
            left++;
            right--;
        }

        return true;
    }
}
