class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, Set<Character>> graph = new HashMap<>();
      Map<Character, Integer> indegree = new HashMap<>();
        // s1: Build graph
        if (!buildGraph(words, graph, indegree)) {
            return "";
        }

        // s2: Topological sort graph
        return topoSort(graph, indegree);
    }

    public boolean buildGraph(String[] words, Map<Character, Set<Character>> graph, Map<Character, Integer> indegree) {
        for (String w : words) {
            for (char c : w.toCharArray()) {
                graph.put(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        int n = words.length;
        for (int i = 0; i < n-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());

            if (
                w1.length() > w2.length() 
                && w1.substring(0, minLen).equals(w2.substring(0, minLen))
            ) {
                return false;
            }

            for (int j = 0; j < minLen; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                // Detect circle
                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2)+1);
                    }
                    break;
                }
            }
        }


        return true;
    }

    public String topoSort(Map<Character, Set<Character>> graph, Map<Character, Integer> indegree) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : graph.keySet()) {
            if (indegree.get(c) == 0) {
                queue.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char nei : graph.get(c)) {
                indegree.put(nei, indegree.get(nei)-1);
                if (indegree.get(nei) == 0) {
                    queue.add(nei);
                }
            }
        }

        if (sb.length() < graph.size()) {
            return "";
        }
        return sb.toString();
    }
}
