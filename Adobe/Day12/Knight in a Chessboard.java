class Solution {
     public double knightProbability(int n, int k, int r, int c) {
         double dp[][][]=new double[n][n][k+1];
         for(double arr[][] : dp){
             for(double a[] : arr){
                 Arrays.fill(a,-1);
             }
         }
         return f(n,k,r,c,dp);
     }
     public double f(int n, int k, int r, int c, double[][][] dp){
         if(k==0) return 1;
         if(dp[r][c][k]!=-1) return dp[r][c][k];
         int dr[]={2,2,-2,-2,1,1,-1,-1};
         int dc[]={1,-1,1,-1,2,-2,2,-2};
         double prob=0;
         for(int i=0; i<8; i++){
             int nr=r+dr[i];
             int nc=c+dc[i];
             if(nr>=0 && nr<n && nc>=0 && nc<n){
                 prob+=0.125*f(n,k-1,nr,nc,dp);
             }
         }
         // System.out.println(prob);
         return dp[r][c][k]=prob;
     }
 }
