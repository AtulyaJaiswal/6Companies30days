// simple graph distance visited use

class Solution {
     public int findTheCity(int n, int[][] e, int d) {
         List<List<Pair>> adj=new ArrayList<>();
         for(int i=0; i<n; i++) adj.add(new ArrayList<>());
         for(int i=0; i<e.length; i++){
             adj.get(e[i][0]).add(new Pair(e[i][1],e[i][2]));
             adj.get(e[i][1]).add(new Pair(e[i][0],e[i][2]));
         }
         // PriorityQueue<Pairs> pq=new PriorityQueue<>();
         int ans=Integer.MAX_VALUE;
         int index=0;
         for(int i=0; i<n; i++){
             int cnt=0;
             Queue<Pair> q=new LinkedList<>();
             int dis[]=new int[n];
             Arrays.fill(dis,Integer.MAX_VALUE);
             int vis[]=new int[n];
             vis[i]=1;
             dis[i]=0;
             q.add(new Pair(i,0));
             while(!q.isEmpty()){
                 int edge=q.peek().e;
                 int wei=q.peek().w;
                 // System.out.println("Edges "+edge+" "+wei);
                 q.remove();
                 for(Pair neigh: adj.get(edge)){
                     int neighWei=neigh.w;
                     int neighNode=neigh.e;
                     if(dis[neighNode]>wei+neighWei && wei+neighWei<=d){
                         dis[neighNode]=wei+neighWei;
                         if(vis[neighNode]==0){
                             cnt++;
                             vis[neighNode]=1;
                         }
                         q.add(new Pair(neighNode,neighWei+wei));
                     }
                 }
             }
             // System.out.println("Count "+cnt+" "+i);
             if(cnt<ans){
                 ans=cnt;
                 index=i;
             }
             else if(cnt==ans){
                 if(i>index){
                     index=i;
                 }
             }
         }
         return index;
     }
 }
 class Pair{
     int e,w;
     Pair(int e, int w){
         this.e=e;
         this.w=w;
     }
 }
 class Pairs implements Comparable<Pairs>{
     int city,ind;
     Pairs(int city, int ind){
         this.city=city;
         this.ind=ind;
     }
     public int compareTo(Pairs that){
         if(this.city==that.city){
             return that.ind-this.ind;
         }
         return this.city-that.city;
     }
 }