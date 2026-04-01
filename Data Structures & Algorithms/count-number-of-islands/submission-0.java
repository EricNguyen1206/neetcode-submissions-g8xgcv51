class Solution {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{-1, 0, 1, 0};

    public int numIslands(char[][] grid) {
        int cnt = 0;
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (isLandDfs(grid, visited, i, j)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public boolean isLandDfs(char[][] grid,boolean[][] visited, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return false;
        if (grid[x][y] == '0' || visited[x][y]) return false;
        visited[x][y] = true;
        for (int i = 0; i<4; i++) {
            int u = x+dx[i];
            int v = y+dy[i];
            isLandDfs(grid, visited, u, v);
        }

        return true;
    }
}
