class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=9;
        for (int i=0;i<n;i++){
            Set<Character> st = new HashSet<>();
            for (int j=0;j<n;j++){
                if (board[i][j] != '.' && st.contains(board[i][j]))
                    return false;
                st.add(board[i][j]);
            }
        }

        for (int j=0;j<n;j++){
            Set<Character> st = new HashSet<>();
            for (int i=0;i<n;i++){
                if (board[i][j] != '.' && st.contains(board[i][j]))
                    return false;
                st.add(board[i][j]);
            }
        }
        for (int sq = 0;sq<n;sq++){
            Set<Character> st = new HashSet<>();
            for (int i=0;i<3;i++){
                for (int j=0;j<3;j++){
                    int row = (sq/3)*3+i;
                    int col=(sq%3)*3+j;
                    if (board[row][col] != '.' && st.contains(board[row][col]))
                        return false;
                    st.add(board[row][col]);
                }
            }
        }
        
        
        return true;
    }
}
