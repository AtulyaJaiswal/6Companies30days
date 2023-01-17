//NOT ACCEPTED
class Solution {
     int mod=(int)1e9+7;
     public int numberOfCombinations(String num) {
         if(num.charAt(0)=='0') return 0;
         // System.out.println(num.length());
         Map<String,Map<Integer,Integer>> hm=new HashMap<>();
         return f(num,"",0,hm);
     }
     public int f(String num, String prev, int i, Map<String,Map<Integer,Integer>> dp){
         // System.out.println(prev);
         if(i==num.length()){
             return 1;
         }
         if(dp.containsKey(prev)){
             Map<Integer,Integer> map=dp.get(prev);
             if(map.containsKey(i)) return map.get(i);
         }
         int a=0;
         for(int j=i; j<num.length(); j++){
             while(j<num.length()-1 && num.charAt(j+1)=='0') j++;
             String x=num.substring(i,j+1);
             // System.out.println(x+" "+prev);
             if(prev.length()>x.length()) continue;
             if(x.length()>prev.length()){
                 a+=f(num,x,j+1,dp)%mod;
             }
             else{
                 int k=0;
                 while(k<x.length()){
                     if(k==x.length()-1 && x.charAt(k)==prev.charAt(k)){
                         a+=f(num,x,j+1,dp)%mod;
                         break;
                     }
                     if(x.charAt(k)==prev.charAt(k)){
                         k++; continue;
                     }
                     if(x.charAt(k)>prev.charAt(k)){
                         a+=f(num,x,j+1,dp)%mod;
                         break;
                     }
                     else if(x.charAt(k)<prev.charAt(k)) break;
                     k++;
                 }
             }
         }
         if(dp.containsKey(prev)){
             Map<Integer,Integer> map=dp.get(prev);
             map.put(i,a);
             dp.put(prev,map);
         }
         else{
             Map<Integer,Integer> map=new HashMap<>();
             map.put(i,a);
             dp.put(prev,new HashMap<>(map));
         }
         return a;
     }
 }
