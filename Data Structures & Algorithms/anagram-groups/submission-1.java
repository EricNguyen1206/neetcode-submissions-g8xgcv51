class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();

        for (String s : strs) {
            int[] fre = new int[26];
            for (char c : s.toCharArray()) {
                fre[c - 'a']++;
            }
            String key = Arrays.toString(fre);
            List<String> anagrams = group.getOrDefault(key, new ArrayList<>());
            anagrams.add(s);
            group.put(key, anagrams);
        }

        return new ArrayList<>(group.values());
    }
}
