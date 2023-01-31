class Solution {
     public List<String> topKFrequent(String[] words, int k) {
         Map<String,Integer> hm=new HashMap<>();
         for(int i=0; i<words.length; i++){
             if(hm.containsKey(words[i])){
                 hm.put(words[i],hm.get(words[i])+1);
             }
             else hm.put(words[i],1);
         }
         // System.out.println(hm);
         PriorityQueue<Pair> pq=new PriorityQueue<>(Collections.reverseOrder());
         for(Map.Entry<String,Integer> map: hm.entrySet()){
             pq.add(new Pair(map.getValue(),map.getKey()));
         }
         // System.out.println(pq.peek().s);
         List<String> ans=new ArrayList<>();
         while(!pq.isEmpty() && ans.size()!=k){
             String temp=pq.peek().s;
             pq.remove();
             ans.add(temp);
         }
         return ans;
     }
 }
 class Pair implements Comparable<Pair>{
     int fre;
     String s;
     Pair(int fre, String s){
         this.fre=fre;
         this.s=s;
     }
     public int compareTo(Pair that){
         if(this.fre==that.fre){
             String s1=that.s;
             String s2=this.s;
             return s1.compareTo(s2);
         }
         return this.fre-that.fre;
     }
 }