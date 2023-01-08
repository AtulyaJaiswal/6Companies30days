// Keep storing latest index of number and if found another one just find the diff in index

class Solution {
     public int minimumCardPickup(int[] cards) {
         Map<Integer,Integer> hm=new HashMap<>();
         int minL=Integer.MAX_VALUE;
         for(int j=0; j<cards.length; j++){
             if(hm.get(cards[j])!=null){
                 int l=j-hm.get(cards[j]);
                 if(l<minL) minL=l;
             }
             hm.put(cards[j],j);
         }
         if(minL==Integer.MAX_VALUE) return -1;
         return minL+1;
     }
 }