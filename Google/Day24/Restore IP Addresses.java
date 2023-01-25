class Solution {
     public List<String> restoreIpAddresses(String s) {
         List<String> ans=new ArrayList<>();
         List<String> temp=new ArrayList<>();
         // System.out.println(Integer.valueOf(s.charAt(1)));
         if(s.length()>12) return ans;
         f(s,ans,3,0,temp);
         return ans;
     }
     public void f(String s, List<String> ans, int dot, int i, List<String> temp){
         // System.out.println(temp+" "+dot);
         if(dot==0){
             if(i<s.length() && Integer.valueOf(s.substring(i,i+1))==0){
                 System.out.println("Reached");
                 if(i==s.length()-1){
                     temp.add(s.substring(i,i+1));
                     String add="";
                     for(String a: temp) add+=a;
                     ans.add(add);
                     temp.remove(temp.size()-1);
                 }
             }
             else if(i<s.length() && Integer.valueOf(s.substring(i,s.length()))<=255){
                 temp.add(s.substring(i,s.length()));
                 String add="";
                 for(String a: temp) add+=a;
                 ans.add(add);
                 temp.remove(temp.size()-1);
             }
             return;
         }
         if(s.length()==i) return;
         if(Integer.valueOf(s.substring(i,i+1))==0){
             temp.add(s.substring(i,i+1));
             temp.add(".");
             f(s,ans,dot-1,i+1,temp);
             temp.remove(temp.size()-1);
             temp.remove(temp.size()-1);
         }
         else{
             for(int j=i;j<i+3 && j<s.length(); j++){
                 if(Integer.valueOf(s.substring(i,j+1))<=255){
                     temp.add(s.substring(i,j+1));
                     temp.add(".");
                     f(s,ans,dot-1,j+1,temp);
                     temp.remove(temp.size()-1);
                     temp.remove(temp.size()-1);
                 }
             }
         }
         return;
     }
 }