class Solution {
     public String predictPartyVictory(String s) {
         int n=s.length();
         Set<Integer> set=new HashSet<>();
         Queue<Integer> q1=new LinkedList<>();
         Queue<Integer> q2=new LinkedList<>();
         for(int i=0; i<s.length(); i++){
             if(s.charAt(i)=='R') q1.add(i);
             else q2.add(i);
         }
         while(q1.size()!=0 && q2.size()!=0){
             int a=q1.remove();
             int b=q2.remove();
             if(a<b) q1.add(a+n);
             else q2.add(b+n);
         }
 
         if(q2.size()==0) return "Radiant";
         else return "Dire";
     }
 }