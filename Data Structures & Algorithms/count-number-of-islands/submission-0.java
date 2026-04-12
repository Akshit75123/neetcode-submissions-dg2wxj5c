class Solution {
    public int numIslands(char[][] grid) {
        int cnt=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j] == '1' && !vis[i][j]){
                    dfs(grid,i,j,vis,drow,dcol,n,m);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void dfs(char[][] grid,int i,int j,boolean[][] vis,int[] drow,int[] dcol,int n,int m){
        vis[i][j] = true;
        for (int k=0;k<4;k++){
            int nr=i+drow[k];
            int nc=j+dcol[k];
            if (nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && grid[nr][nc]=='1'){
                dfs(grid,nr,nc,vis,drow,dcol,n,m);
            }
        }
    }
}
