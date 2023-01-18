sieve problem

class Solution {
     public boolean[] sieve(int n){
         boolean isP[]=new boolean[n+1];
         Arrays.fill(isP,true);
         isP[0]=false;
         isP[1]=false;
         for(int i=2; i*i<=n; i++){
             for(int j=2*i; j<=n; j+=i){
                 isP[j]=false;
             }
         }
         return isP;
     }
     public int[] closestPrimes(int left, int right) {
         int[] ans=new int[2];
         ans[0]=-1;
         ans[1]=-1;
         boolean isP[]=sieve(1000001);
         int f=0,diff=Integer.MAX_VALUE;
         for(int i=left; i<=right; i++){
             if(isP[i]==true){
                 f=i;
                 break;
             }
         }
         if(f!=0){
             for(int i=f+1; i<=right; i++){
                 // System.out.println(ans[0]+" "+ans[1]);
                 if(isP[i]==true){
                     if(i-f<diff){
                         diff=i-f;
                         ans[0]=f;
                         ans[1]=i;
                     }
                     f=i;
                 }
             }
         }
         return ans;
     }
 }