class Solution {
    /**
        Approach: encode string with 
    */
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            // Format: length + "#" + string
            res.append(s.length()).append("#").append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {
            // Find the "#" delimiter
            int delimiterPos = str.indexOf('#', i);
            
            // Extract the length
            int length = Integer.parseInt(str.substring(i, delimiterPos));
            
            // Extract the string of that length
            int start = delimiterPos + 1;
            res.add(str.substring(start, start + length));
            
            // Move to next encoded string
            i = start + length;
        }
        
        return res;
    }
}
