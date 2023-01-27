// max number of substring jisme toot ske

class Solution {
     Set<String> hs=new HashSet<>();
     int answ=0;
     public int maxUniqueSplit(String s) {
         f(s,0);
         // System.out.println(ans);
         return answ;
     }
     public void f(String s, int j){
         if(j==s.length()){
             // System.out.println(hs);
             answ=Math.max(answ,hs.size());
             return;
         }
         for(int i=j; i<s.length(); i++){
             if(hs.contains(s.substring(j,i+1))) continue;
             else{
                 hs.add(s.substring(j,i+1));
                 f(s,i+1);
                 hs.remove(s.substring(j,i+1));
             }
         }
     }
 }