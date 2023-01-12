class Solution {
     public int magicalString(int n) {
         String s="122";
         int i=2,prev=1;
         while(s.length()<=n){
             int a=s.charAt(i)-'0';
             while(a--!=0) s+=String.valueOf(prev);
             if(prev==1) prev=2;
             else prev=1;
             i++;
         }
         int cnt=0;
         for(i=0; i<n; i++){
             if(s.charAt(i)=='1') cnt++;
         }
         return cnt;
     }
}
