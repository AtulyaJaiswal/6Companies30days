// take each string from array and keep matching


class Solution {
     int ans=0;
     public int numMatchingSubseq(String s, String[] words) {
         Map<String,Integer> hm=new HashMap<>();
         for(int i=0; i<words.length; i++){
             if(hm.containsKey(words[i])){
                 hm.put(words[i],hm.get(words[i])+1);
             }
             else hm.put(words[i],1);
         }
         int ans=0;
         char[] str=s.toCharArray();
         for(String t: hm.keySet()){
             char[] temp=t.toCharArray();
             int i=0,j=0;
             while(i<str.length && j<temp.length){
                 if(str[i]==temp[j]){
                     i++;
                     j++;
                 }
                 else i++;
             }
             if(j==temp.length) ans+=hm.get(t);
         }
         return ans;
     }
 }