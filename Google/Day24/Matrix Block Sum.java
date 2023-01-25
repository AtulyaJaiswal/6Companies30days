class Solution {
     public int[][] matrixBlockSum(int[][] mat, int k) {
         int m=mat.length;
         int n=mat[0].length;
         int ans[][]=new int[m][n];
         for(int i=0; i<m; i++){
             for(int j=0; j<n; j++){
                 int lx=i-k,hx=i+k,ly=j-k,hy=j+k;
                 for(int x=lx; x<=hx; x++){
                     for(int y=ly; y<=hy; y++){
                         if(x>=0 && x<m && y>=0 && y<n){
                             ans[x][y]+=mat[i][j];
                         }
                     }
                 }
             }
         }
         return ans;
     }
 }


//Prefix sum method
 class Solution {
     public int[][] matrixBlockSum(int[][] mat, int k) {
         int m = mat.length;
         int n = mat[0].length;
         int[][] sum = new int[m][n];
         for(int i = 0; i < m; i++){
             for(int j = 0; j < n; j++){
                 if(i == 0 && j == 0){
                     sum[i][j] = mat[i][j];
                 }else if(i == 0){
                     sum[0][j] = sum[0][j - 1] + mat[i][j];
                 }else if(j == 0){
                     sum[i][0] = sum[i - 1][j] + mat[i][j];
                 }else{
                     sum[i][j] = mat[i][j] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
                 }
             }
         }
         int[][] result = new int[m][n];
         for(int i = 0; i < m; i++){
             int iLow = Math.max(i - k, 0);
             int iHigh = Math.min(i + k, m - 1);
             for(int j = 0; j < n; j++){
                 int jLow = Math.max(j - k, 0);
                 int jHigh = Math.min(j + k, n - 1);
                 if(iLow == 0 && jLow == 0){
                     result[i][j] = sum[iHigh][jHigh];
                 }
                 else if(iLow == 0){
                     result[i][j] = sum[iHigh][jHigh] - sum[iHigh][jLow - 1];
                 }
                 else if(jLow == 0){
                     result[i][j] = sum[iHigh][jHigh] - sum[iLow - 1][jHigh];
                 }else{
                     result[i][j] = sum[iHigh][jHigh] - sum[iHigh][jLow - 1] - sum[iLow - 1][jHigh] + sum[iLow - 1][jLow - 1];
                 }
             }
         }
         return result;
     }
 }