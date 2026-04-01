class Solution {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        Map<Character, Character> closeToOpen = new HashMap();
        closeToOpen.put(')', '(');
        closeToOpen.put('}', '{');
        closeToOpen.put(']', '[');

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (stack.size() == 0) return false;

                char lastC = stack.get(stack.size()-1);
                if (closeToOpen.get(c) != lastC) return false;

                stack.remove(stack.size()-1);
            } else {
                stack.add(c);
            }
        }

        return stack.size() == 0;
    }
}
