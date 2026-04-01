class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i<9; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> bloc = new HashSet<>();
            for (int j = 0; j<9; j++) {
                char c1 = board[i][j];
                char c2 = board[j][i];
                int x = (i%3) * 3 + (j%3); // i = 4, j = 4 => 3 + 1 = 4
                int y = (i/3) * 3 + (j/3); // i=4, j=4 => 3 + 1 = 4
                char c3 = board[x][y];
                if (row.contains(c1) || col.contains(c2) || bloc.contains(c3)) return false;
                if (c1 != '.') row.add(c1);
                if (c2 != '.') col.add(c2);
                if (c3 != '.') bloc.add(c3);
            }
        }

        return true;
    }
}
