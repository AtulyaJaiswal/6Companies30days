// HashMap && Sliding Window


class Solution {
     public int totalFruit(int[] fr) {
         Map<Integer,Integer> hm=new HashMap<>();
         int i=0,cnt=0,max=0;
         for(int j=0; j<fr.length; j++){
             if(hm.containsKey(fr[j])){
                 hm.put(fr[j],hm.get(fr[j])+1);
             }
             else hm.put(fr[j],1);
             // System.out.println(hm+" "+cnt);
             if(hm.size()<=2){
                 cnt++;
                 max=Math.max(cnt,max);
             }  
             else{
                 while(hm.size()!=2){
                     // System.out.println(hm+" "+cnt);
                     cnt--;
                     if(hm.get(fr[i])==1){
                         hm.remove(fr[i]);
                     }
                     else{
                         hm.put(fr[i],hm.get(fr[i])-1);
                     }
                     i++;
                 }
                 cnt++;
                 max=Math.max(cnt,max);
             }
         }
         return max;
     }
 }