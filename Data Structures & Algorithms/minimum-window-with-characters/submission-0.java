class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> cntT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            cntT.put(c, cntT.getOrDefault(c, 0)+1);
        }
        int have = 0, need = cntT.size();
        int l = 0;
        int[] res = {-1, -1};
        int minLen = Integer.MAX_VALUE;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0)+1);
            if (cntT.containsKey(c) && window.get(c).equals(cntT.get(c))) {
                have++;
            }

            while(have == need) {
                if (r-l+1 < minLen) {
                    res[0]=l;
                    res[1]=r;
                    minLen=r-l+1;
                }

                char c2 = s.charAt(l);
                window.put(c2, window.get(c2)-1);
                if (cntT.containsKey(c2) && window.get(c2)<cntT.get(c2)) {
                    have--;
                }
                l++;
            }
        }

        return minLen != Integer.MAX_VALUE ? s.substring(res[0], res[1]+1) : "";
    }
}
