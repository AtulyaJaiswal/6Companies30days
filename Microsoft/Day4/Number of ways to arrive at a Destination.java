// time aur ways ka array manage krte chalo 
// and time waale se jyada mile to dnt update kam mile to update
// ways me agar same time mil jaaye to add kr do prev waale se else nya time mile to uss hisaab se update.

class Solution {
     int mod=(int)1e9+7;
     public int countPaths(int n, int[][] roads) {
         List<List<Pairs>> adj=new ArrayList<>();
         for(int i=0; i<n; i++) adj.add(new ArrayList<>());
         for(int i=0; i<roads.length; i++){
             adj.get(roads[i][0]).add(new Pairs(roads[i][1],roads[i][2]));
             adj.get(roads[i][1]).add(new Pairs(roads[i][0],roads[i][2]));
         }
         long time[]=new long[n];
         long ways[]=new long[n];
         Arrays.fill(time,(long)1e12);
         // Arrays.fill(ways,1);
         Queue<Pair> q=new PriorityQueue<>();
         time[0]=0;
         ways[0]=1;
         q.add(new Pair(0,0));
         while(q.size()!=0){
             int t=q.peek().time;
             int node=q.peek().node;
             // System.out.println(t+" "+node);
             q.remove();
             for(Pairs neigh: adj.get(node)){
                 int neighNode=neigh.node;
                 int neighTime=neigh.time;
                 long temp=(long)t+(long) neighTime;
                 if(time[neighNode]>t+neighTime){
                     time[neighNode]=t+neighTime;
                     q.add(new Pair((int)t+neighTime,neighNode));
                     ways[neighNode]=ways[node];
                 }
                 else if(time[neighNode]==(t+neighTime)){
                     ways[neighNode]=(ways[neighNode]+ways[node])%mod;
                 }
             }
         }
         // for(int i=0; i<n; i++) System.out.println(ways[i]);
         return (int)ways[n-1];
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
