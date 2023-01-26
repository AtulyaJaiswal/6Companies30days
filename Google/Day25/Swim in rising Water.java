class Solution {
     public int swimInWater(int[][] grid) {
         int dr[]={0,0,1,-1};
         int dc[]={1,-1,0,0};
         PriorityQueue<Pair> pq=new PriorityQueue<>();
         int vis[][]=new int[grid.length][grid.length];
         pq.add(new Pair(grid[0][0],0,0));
         while(!pq.isEmpty()){
             int q=pq.peek().val;
             int x=pq.peek().i;
             int y=pq.peek().j;
             pq.remove();
             if(x==grid.length-1 && y==grid.length-1){
                 return q;
             }
             for(int i=0; i<4; i++){
                 int newr=x+dr[i];
                 int newc=y+dc[i];
                 if(newr>=0 && newr<grid.length && newc>=0 && newc<grid.length && vis[newr][newc]==0){
                     vis[newr][newc]=1;
                     pq.add(new Pair(Math.max(q,grid[newr][newc]),newr,newc));
                 }
             }
         }
         return 0;
     }
 }
 class Pair implements Comparable<Pair>{
     int val,i,j;
     Pair(int val, int i, int j){
         this.val=val;
         this.i=i;
         this.j=j;
     }
     public int compareTo(Pair that){
         return this.val-that.val;
     }
}


// Solution -> 2
class Solution {
     public int swimInWater(int[][] grid) {
         int vis[][]=new int[grid.length][grid.length];
         int dp[][][]=new int[grid.length][grid.length][grid.length*grid.length+1];
         for(int[][] a: dp){
             for(int[] b: a) Arrays.fill(b,-1);
         }
         return f(grid,0,0,vis,dp,0);
     }
     public int f(int[][] g, int i, int j, int[][] vis,int[][][] dp, int time){
         if(i==g.length-1 && j==g[0].length-1){
             return g[i][j];
         }
         if(dp[i][j][time]!=-1) return dp[i][j][time];
         int max=g[i][j];
         int min=Integer.MAX_VALUE;
         int dr[]={0,0,-1,1};
         int dc[]={1,-1,0,0};
         vis[i][j]=1;
         for(int k=0; k<4; k++){
             int newr=dr[k]+i;
             int newc=dc[k]+j;
             if(newr>=0 && newc>=0 && newr<g.length && newc<g.length && vis[newr][newc]==0){
                 min=Math.min(min,Math.max(max,f(g,newr,newc,vis,dp,Math.max(time,g[i][j]))));
             }
         }
         // int r=Math.max(max,f(g,i+1,j));
         // int l=Math.max(max,f(g,i,j+1));
         vis[i][j]=0;
         return dp[i][j][time]=min;
     }
}