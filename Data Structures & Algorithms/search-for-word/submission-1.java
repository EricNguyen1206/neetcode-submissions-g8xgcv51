class Solution {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{-1, 0, 1, 0};
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        boolean[][] travels = new boolean[r][c];
        for (int i = 0; i<r; i++) {
            for (int j = 0; j<c; j++) {
                if (dfs(board, word, i, j, 0, travels)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String work, int x, int y, int index, boolean[][] travels) {
        if (index == work.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (travels[x][y] || work.charAt(index) != board[x][y]) return false;

        travels[x][y] = true;
        boolean res = false;
        for (int i = 0; i<4; i++) {
            int u = x + dx[i];
            int v = y + dy[i];
            res = res || dfs(board, work, u, v, index+1, travels);
        }
        travels[x][y] = false;

        return res;
    }
}
