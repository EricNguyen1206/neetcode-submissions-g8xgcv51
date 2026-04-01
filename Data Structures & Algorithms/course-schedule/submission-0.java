class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // Build adjacency list
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }
        
        int[] status = new int[numCourses];
        for (int i = 0; i<numCourses; i++) {
            if (status[i] == 0 && !dfs(graph, status, i)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(List<List<Integer>> graph, int[] status, int course) {
        // Detec circle
        if (status[course] == 1) return false;
        if (status[course] == 2) return true;

        status[course] = 1; // course visiting

        for (int pre : graph.get(course)) {
            if (!dfs(graph, status, pre)) {
                return false;
            }
        }

        status[course] = 2;

        return true;
    }
}
