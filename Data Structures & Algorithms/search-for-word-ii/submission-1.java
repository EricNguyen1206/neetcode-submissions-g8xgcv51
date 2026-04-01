class Solution {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{-1, 0, 1, 0};
 
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> found = new HashSet<>(); // Tránh duplicate
        
        for (String word : words) {
            if (found.contains(word)) continue; // Skip nếu đã tìm thấy
            
            boolean wordFound = false;
            for (int i = 0; i < board.length && !wordFound; i++) {
                for (int j = 0; j < board[0].length && !wordFound; j++) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (dfs(board, visited, i, j, word, 0)) {
                        result.add(word);
                        found.add(word);
                        wordFound = true;
                    }
                }
            }
        }
        
        return result;
    }

private boolean dfs(char[][] board, boolean[][] visited, int x, int y, String word, int index) {
        // Check bounds
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        
        // Check if already visited
        if (visited[x][y]) return false;
        
        // Check character match
        if (board[x][y] != word.charAt(index)) return false;
        
        // Check if we found complete word
        if (index == word.length() - 1) return true;
        
        // Mark as visited
        visited[x][y] = true;
        
        // Try all 4 directions
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (dfs(board, visited, newX, newY, word, index + 1)) {
                visited[x][y] = false; // Backtrack
                return true;
            }
        }
        
        // Backtrack
        visited[x][y] = false;
        return false;
    }
}
