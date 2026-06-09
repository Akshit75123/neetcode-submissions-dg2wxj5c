class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        // Fixed dimensions: rows (n) then columns (m)
        boolean[][] vis = new boolean[n][m];
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Only start DFS if the first character matches
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, board, word, vis, 0, dr, dc, n, m)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, char[][] board, String word, boolean[][] vis, int k, int[] dr, int[] dc, int n, int m) {
        // Base case: If we successfully matched the last character
        if (k == word.length() - 1) {
            return true;
        }
        
        // 1. Mark the current cell as visited
        vis[i][j] = true;
        
        // 2. Explore all 4 neighbors
        for (int s = 0; s < 4; s++) {
            int newRow = i + dr[s];
            int newCol = j + dc[s];

            // Validate boundaries, visited array, and character match for the NEXT character (k + 1)
            if (newRow < n && newRow >= 0 && newCol < m && newCol >= 0 
                && !vis[newRow][newCol] && board[newRow][newCol] == word.charAt(k + 1)) {
                
                if (dfs(newRow, newCol, board, word, vis, k + 1, dr, dc, n, m)) {
                    return true;
                }
            }
        }
        
        // 3. BACKTRACK: Unmark this cell so other alternative paths can use it
        vis[i][j] = false;
        
        return false;
    }
}