class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (int i = 0; i<strs.length; i++) {
            int[] fre = new int[26];
            for (char c : strs[i].toCharArray()) {
                fre[c - 'a']++;
            }
            String key = Arrays.toString(fre);
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(strs[i]);
        }

        List<List<String>> res = new ArrayList<>();
        for (String key : groups.keySet()) {
            res.add(groups.get(key));
        }

        return res;
    }
}
