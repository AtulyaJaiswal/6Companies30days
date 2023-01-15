class Solution {
     public int calculateMinimumHP(int[][] d) {
         int m=d.length;
         int n=d[0].length;
         int dp[][]=new int[m][n];
         for(int[] x: dp) Arrays.fill(x,(int)1e9);
         return f(0,0,d,dp);
     }
     public int f(int m, int n, int[][] d, int[][] dp){
         if(m>=d.length || n>=d[0].length) return Integer.MAX_VALUE;
         if(m==d.length-1 && n==d[0].length-1){
             if(d[m][n]<0) return -d[m][n]+1;
             return 1;
         }
         if(dp[m][n]!=(int)1e9) return dp[m][n];
         int a=f(m+1,n,d,dp);
         int b=f(m,n+1,d,dp);
         int min=Math.min(a,b)-d[m][n];
 
         if(min<=0) return dp[m][n]=1;
         return dp[m][n]=min;
     }
 }