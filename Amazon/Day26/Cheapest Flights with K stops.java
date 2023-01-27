// Simple bfs ques

class Solution {
     public int findCheapestPrice(int n, int[][] fli, int src, int dst, int k) {
         List<List<Pairs>> adj=new ArrayList<>();
         for(int i=0; i<n; i++) adj.add(new ArrayList<>());
         for(int i=0; i<fli.length; i++){
             adj.get(fli[i][0]).add(new Pairs(fli[i][1],fli[i][2]));
         }
         // System.out.println(adj);
         int dis[]=new int[n];
         Arrays.fill(dis,Integer.MAX_VALUE);
         Queue<Pair> q=new LinkedList<>();
         q.add(new Pair(src,0,0));
         while(!q.isEmpty()){
             int node=q.peek().node;
             int wei=q.peek().wei;
             int tk=q.peek().k;
             q.remove();
             if(tk>k) continue;
 
             for(Pairs neigh: adj.get(node)){
                 int neighNode=neigh.node;
                 int neiWei=neigh.wei;
                 if(dis[neighNode]>wei+neiWei){
                     dis[neighNode]=wei+neiWei;
                     q.add(new Pair(neighNode,wei+neiWei,tk+1));
                 }
             }
         }
         if(dis[dst]==Integer.MAX_VALUE) return -1;
         else return dis[dst];
     }
 }
 class Pair{
     int node,wei,k;
     Pair(int node, int wei, int k){
         this.node=node;
         this.wei=wei;
         this.k=k;
     }
 }
 class Pairs{
     int node,wei;
     Pairs(int node, int wei){
         this.node=node;
         this.wei=wei;
     }
 }