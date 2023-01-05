// sliding window and 2 pointer use kro jb tk possible ho count every substring


class Solution {
     public int numberOfSubstrings(String s) {
         int left=0,res=0;
         int[] fre=new int[3];
         for(int i=0; i<s.length(); i++){
             fre[s.charAt(i)-'a']++;
             while(fre[0]>0 && fre[1]>0 && fre[2]>0){
                 res+=s.length()-i;
                 fre[s.charAt(left)-'a']--;
                 left++;
             }
         }
         return res;
     }
 }
