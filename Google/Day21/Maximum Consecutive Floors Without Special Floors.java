class Solution {
     public int maxConsecutive(int b, int t, int[] s) {
         Arrays.sort(s);
         int max=0;
         max=Math.max(s[0]-b,max);
         for(int i=1; i<s.length; i++){
             if(s[i]<=t){
                 max=Math.max(s[i]-s[i-1]-1,max);
             }
             else break;
         }
         if(s[s.length-1]<t) max=Math.max(t-s[s.length-1],max);
         return max;
     }
 }