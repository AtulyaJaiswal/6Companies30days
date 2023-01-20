class Solution {
     public String customSortString(String order, String s) {
         int o=order.length();
         int n=s.length();
         Map<Character,Integer> hm=new HashMap<>();
         for(int i=0; i<n; i++){
             if(hm.containsKey(s.charAt(i))) hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
             else hm.put(s.charAt(i),1);
         }
         // System.out.println(hm);
         String ans="";
         for(int i=0; i<o; i++){
             String temp=String.valueOf(order.charAt(i));
             if(s.contains(temp)){
                 int fre=hm.get(order.charAt(i));
                 while(fre--!=0){
                     ans+=temp;
                 }
             }
         }
         for(int i=0; i<n; i++){
             String temp=String.valueOf(s.charAt(i));
             if(!ans.contains(temp)){
                 int fre=hm.get(s.charAt(i));
                 while(fre--!=0){
                     ans+=temp;
                 }
             }
         }
         return ans;
     }
 }
