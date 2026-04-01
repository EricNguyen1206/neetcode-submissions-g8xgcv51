class Solution {
    int ROW, COL;
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{-1, 0, 1, 0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROW = heights.length;
        COL = heights[0].length;
        boolean [][] pac = new boolean[ROW][COL];
        boolean [][] atl = new boolean[ROW][COL];

        List<List<Integer>> res = new ArrayList<>();

        for (int c = 0; c < COL; c++) {
            dfs(heights, pac, 0, c);
            dfs(heights, atl, ROW-1, c);
        }

        for (int r = 0; r < ROW; r++) {
            dfs(heights, pac, r, 0);
            dfs(heights, atl, r, COL-1);
        }

        for (int i = 0; i<ROW; i++) {
            for (int j = 0; j<COL; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int r, int c) {
        ocean[r][c] = true;
        for (int i = 0; i<4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (nr >= 0 && nr < ROW && nc >= 0 && nc < COL
            && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(heights, ocean, nr, nc);
            }
        }
    }
}
