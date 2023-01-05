// gcd nikaalke check krlo kaun sa sbse cjota number divide kr raa isko

class Solution {
     public int gcd(int a, int b){
         if(b==0) return a;
         return gcd(b,a%b);
     }
     public int minOperations(int[] n, int[] nD) {
         int finalgcd=nD[0];
         for(int i=1; i<nD.length; i++){
             finalgcd=gcd(finalgcd,nD[i]);
         }
         Arrays.sort(n);
         int cnt=0;
         for(int i=0; i<n.length; i++){
             if(finalgcd%n[i]==0) return cnt;
             else cnt++;
         }
         return -1;
     }
 }
