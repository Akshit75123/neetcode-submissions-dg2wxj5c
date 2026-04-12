class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        int max=0;
        int[] cnt = {1};
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j] == 1 && !vis[i][j]){
                    cnt[0]=1;
                    dfs(grid,i,j,vis,drow,dcol,n,m,cnt);
                    max=Math.max(cnt[0],max);
                }
            }
        }
        return max;
    }
    public void dfs(int[][] grid,int i,int j,boolean[][] vis,int[] drow,int[] dcol,int n,int m,int[] cnt){
        vis[i][j] = true;
        for (int k=0;k<4;k++){
            int nr=i+drow[k];
            int nc=j+dcol[k];
            if (nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && grid[nr][nc]==1){
                dfs(grid,nr,nc,vis,drow,dcol,n,m,cnt);
                cnt[0]++;
            }
        }
    }
}
