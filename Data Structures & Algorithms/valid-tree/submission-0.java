class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) return false;

        int[] parents = new int[n];
        for (int i = 0; i<n; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            int r1 = find(parents, edge[0]);
            int r2 = find(parents, edge[1]);
            if (r1 == r2) {
                return false;
            }

            parents[r1] = r2;
        }

        return true;
    }

    public int find(int[] parents, int x) {
        if (parents[x] != x) {
            parents[x] = find(parents, parents[x]);
        }

        return parents[x];
    }
}
