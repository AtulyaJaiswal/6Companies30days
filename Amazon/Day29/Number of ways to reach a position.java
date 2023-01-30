class Solution {
     int mod=(int)1e9+7;
     public int numberOfWays(int s, int e, int k) {
         // int dis=Math.abs(s-k)+Math.abs(s+k);
         int dp[][]=new int[s+(2*k)+1][k+1];
         for(int[] a: dp) Arrays.fill(a,-1);
         // Map<Integer,Map<Integer,Integer>> hm=new HashMap<>();
         // return f(s,e,k,k,dp);
     }
     public int f(int s, int e, int k,int fk, int dp[][]
     //  Map<Integer,Map<Integer,Integer>> hm
      ){
         if(k==0){
             if(s==e){
                 return 1;
             }
             return 0;
         }
         if(dp[s+fk][k]!=-1) return dp[s+fk][k]%mod;
         int l=f(s-1,e,k-1,fk,dp)%mod;
         int r=f(s+1,e,k-1,fk,dp)%mod;
         // if(hm.containsKey(s)){
         //     Map<Integer,Integer> temp=hm.get(s);
         //     if(temp.containsKey(k)) return temp.get(k)%mod;
         // }
         // int l=f(s-1,e,k-1,fk,hm)%mod;
         // int r=f(s+1,e,k-1,fk,hm)%mod;
         int tot=(l+r)%mod;
         // if(hm.containsKey(s)){
         //     Map<Integer,Integer> temp=hm.get(s);
         //     temp.put(k,tot);
         //     hm.put(s,temp);
         // }
         // else{
         //     Map<Integer,Integer> temp=new HashMap<>();
         //     temp.put(k,tot);
         //     hm.put(s,new HashMap<>(temp));
         // }
         return dp[s+fk][k]=tot;
     }
 }