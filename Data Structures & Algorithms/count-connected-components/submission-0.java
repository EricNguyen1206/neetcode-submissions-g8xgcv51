class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            graph.add(new ArrayList<>());
        }
        // Build Adjacency list
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int cnt = 0;

        for (int i = 0; i<n; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(graph, visited, i);
            }
        }
        return cnt;
    }

    public void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                dfs(graph, visited, nei);
            }
        }
    }
}
