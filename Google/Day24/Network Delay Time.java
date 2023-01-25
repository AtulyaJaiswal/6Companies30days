class Solution {
     public int networkDelayTime(int[][] times, int n, int k) {
         List<List<Pairs>> adj=new ArrayList<>();
         for(int i=0; i<=n; i++) adj.add(new ArrayList<>());
         for(int i=0; i<times.length; i++){
             adj.get(times[i][0]).add(new Pairs(times[i][1],times[i][2]));
         }
         Queue<Pair> q=new PriorityQueue<>();
         int time[]=new int[n+1];
         Arrays.fill(time,(int)1e9);
         time[k]=0;
         q.add(new Pair(0,k));
         while(q.size()!=0){
             int t=q.peek().time;
             int node=q.peek().node;
             q.remove();
             for(Pairs neigh: adj.get(node)){
                 int neighTime=neigh.time;
                 int neighNode=neigh.node;
                 if(time[neighNode]>t+neighTime){
                     time[neighNode]=t+neighTime;
                     q.add(new Pair(t+neighTime,neighNode));
                 }
             }
         }
         int ans=0;
         // for(int i=0; i<=n; i++) System.out.println(time[i]);
         for(int i=1; i<=n; i++){
             if(time[i]==(int)1e9) return -1;
             if(time[i]>ans) ans=time[i];
         }
         return ans;
     }
 }
 class Pairs{
     int node,time;
     public Pairs(int node, int time){
         this.node=node;
         this.time=time;
     }
 }
 class Pair implements Comparable<Pair>{
 int time,node;
     public Pair(int time, int node){
         this.time=time;
         this.node=node;
     }
     public int compareTo(Pair that){
         return this.time-that.time;
     }
 }