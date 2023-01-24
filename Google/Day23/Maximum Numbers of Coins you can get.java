class Solution {
     public int maxCoins(int[] piles) {
         Arrays.sort(piles);
         int max=0,j=0;
         int cnt=piles.length/3;
         for(int i=piles.length-2; i>=0 && cnt>0; i-=2){
             max+=piles[i];
             cnt--;
         }
         return max;
     }
 }