// METHOD->1

class Solution {
     public int[] rearrangeBarcodes(int[] b) {
         int n=b.length;
         int[] ans=new int[n];
         PriorityQueue<Pair> pq=new PriorityQueue<>(Collections.reverseOrder());
         Map<Integer,Integer> hm=new HashMap<>();
         for(int i=0; i<n; i++){
             if(hm.containsKey(b[i])){
                 hm.put(b[i],hm.get(b[i])+1);
             }
             else hm.put(b[i],1);
         }
         for(Map.Entry<Integer,Integer> map: hm.entrySet()){
             pq.add(new Pair(map.getValue(),map.getKey()));
         }
         int prev=0;
         for(int i=0; i<n; i++){
             List<Pair> l=new ArrayList<>();
             while(pq.peek().num==prev) l.add(pq.poll());
             Pair top=pq.poll();
             int fre=top.fre;
             int num=top.num;
             ans[i]=num;
             prev=num;
             pq.add(new Pair(fre-1,num));
             for(int j=0; j<l.size(); j++) pq.add(l.get(j));
         }
         return ans;
     }
 }
 class Pair implements Comparable<Pair>{
     int fre,num;
     Pair(int fre, int num){
         this.fre=fre;
         this.num=num;
     }
     public int compareTo(Pair that){
         if(this.fre==that.fre){
             return that.num-this.num;
         }
         return this.fre-that.fre;
     }
 }

//  METHOD->2

 class Solution {
     public int[] rearrangeBarcodes(int[] b) {
         int n=b.length;
         int[] ans=new int[n];
         PriorityQueue<Pair> pq=new PriorityQueue<>(Collections.reverseOrder());
         Map<Integer,Integer> hm=new HashMap<>();
         for(int i=0; i<n; i++){
             if(hm.containsKey(b[i])){
                 hm.put(b[i],hm.get(b[i])+1);
             }
             else hm.put(b[i],1);
         }
         for(Map.Entry<Integer,Integer> map: hm.entrySet()){
             pq.add(new Pair(map.getValue(),map.getKey()));
         }
         int i=0;
         while(pq.size()!=0){
             Pair top=pq.poll();
             int fre=top.fre;
             int num=top.num;
             while(fre!=0){
                 ans[i]=num;
                 i+=2;
                 if(i>=n) i=1;
                 fre--;
             }
         }
         return ans;
     }
 }
 class Pair implements Comparable<Pair>{
     int fre,num;
     Pair(int fre, int num){
         this.fre=fre;
         this.num=num;
     }
     public int compareTo(Pair that){
         if(this.fre==that.fre){
             return that.num-this.num;
         }
         return this.fre-that.fre;
     }
 }