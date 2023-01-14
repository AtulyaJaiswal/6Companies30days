class StockPrice {
     Map<Integer,Integer> hm;
     PriorityQueue<Pair> pq1;
     PriorityQueue<Pair> pq2;
     int cur=0,time=0;
     public StockPrice() {
         hm=new HashMap<>();
         pq1=new PriorityQueue<>();
         pq2=new PriorityQueue<>(Collections.reverseOrder());
     }
     
     public void update(int t, int p) {
         hm.put(t,p);
         pq1.add(new Pair(p,t));
         pq2.add(new Pair(p,t));
         if(t>=time){
             time=t;
             cur=p;
         }
     }
     
     public int current() {
         return cur;
     }
     
     public int maximum() {
         int pr=0;
         while(true){
             Pair x=pq2.peek();
             int ti=x.t;
             pr=x.p;
             if(hm.containsKey(ti) && hm.get(ti)==pr) break;
             else pq2.remove();
         }
         return pr;
     }
     
     public int minimum() {
         int pr=0;
         while(true){
             Pair x=pq1.peek();
             int ti=x.t;
             pr=x.p;
             if(hm.containsKey(ti) && hm.get(ti)==pr) break;
             else pq1.remove();
         }
         return pr;
     }
 }
 class Pair implements Comparable<Pair>{
     int p,t;
     Pair(int p,int t){
         this.p=p;
         this.t=t;
     }
     public int compareTo(Pair that){
         return this.p-that.p;
     }
 }
 
 /**
  * Your StockPrice object will be instantiated and called as such:
  * StockPrice obj = new StockPrice();
  * obj.update(timestamp,price);
  * int param_2 = obj.current();
  * int param_3 = obj.maximum();
  * int param_4 = obj.minimum();
  */
