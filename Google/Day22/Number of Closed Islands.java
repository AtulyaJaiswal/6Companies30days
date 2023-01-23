class Solution {
     public int closedIsland(int[][] grid) {
         int m=grid.length;
         int n=grid[0].length;
         int vis[][]=new int[m][n];
         // System.out.println(m+" "+n);
         for(int i=0; i<n; i++){
             if(grid[0][i]==0 && vis[0][i]==0){
                 dfs(vis,grid,0,i);
             }
             if(grid[m-1][i]==0 && vis[m-1][i]==0){
                 dfs(vis,grid,m-1,i);
             }
         }
         for(int i=0; i<m; i++){
             if(grid[i][0]==0 && vis[i][0]==0){
                 dfs(vis,grid,i,0);
             }
             if(grid[i][n-1]==0 && vis[i][n-1]==0){
                 dfs(vis,grid,i,n-1);
             }
         }
         int cnt=0;
         for(int i=0; i<m; i++){
             for(int j=0; j<n; j++){
                 if(grid[i][j]==0 && vis[i][j]==0){
                     cnt++;
                     dfs(vis,grid,i,j);
                 }
             }
         }
         return cnt;
     }
     public void dfs(int[][] vis, int[][] grid, int i, int j){
         vis[i][j]=1;
         int dr[]={0,0,1,-1};
         int dc[]={1,-1,0,0};
         for(int k=0; k<4; k++){
             int newr=i+dr[k];
             int newc=j+dc[k];
             if(newr>=0 && newr<grid.length && newc>=0 && newc<grid[0].length){
                 if(grid[newr][newc]==0 && vis[newr][newc]==0){
                     dfs(vis,grid,newr,newc);
                 }
             }
         }
     }
 }