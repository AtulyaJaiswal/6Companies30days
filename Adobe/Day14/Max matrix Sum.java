// even neg hoga to sb pos
// else sbse min waala reh jaiga

class Solution {
     public long maxMatrixSum(int[][] mat) {
         int n=mat.length;
         int min=Integer.MAX_VALUE;
         long sum=0;
         int neg=0;
         for(int i=0; i<n; i++){
             for(int j=0; j<n; j++){
                 if(Math.abs(mat[i][j])<min) min=Math.abs(mat[i][j]);
                 sum+=Math.abs(mat[i][j]);
                 if(mat[i][j]<0) neg++;
             }
         }
         if(neg%2==0) return sum;
         else return sum-(2*min);
     }
 }
