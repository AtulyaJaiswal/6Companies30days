class Solution {
     public boolean hasAllCodes(String s, int k) {
         if(s.length()<k) return false;
         Set<String> l=new HashSet<>();
         for(int i=k; i<=s.length(); i++){
             l.add(s.substring(i-k,i));
         }
         System.out.println(l);
         if(l.size()>=Math.pow(2,k)) return true;
         return false;
     }
 }