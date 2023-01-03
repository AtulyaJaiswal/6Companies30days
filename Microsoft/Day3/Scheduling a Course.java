// As scheduling is asked and ye pucha gya ki ek ke pehle kaun aaya
// isliye topo sort


class Solution {
     public boolean canFinish(int n, int[][] p) {
         List<List<Integer>> adj=new ArrayList<>();
         int[] indeg=new int[n];
         for(int i=0; i<n; i++) adj.add(new ArrayList<>());
         for(int i=0; i<p.length; i++){
             adj.get(p[i][1]).add(p[i][0]);
             indeg[p[i][0]]++;
         }
         int vis[]=new int[n];
         Stack<Integer> st=new Stack<>();
         Queue<Integer> q=new LinkedList<>();
         for(int i=0; i<n; i++){
             if(indeg[i]==0) q.add(i);
         }
         while(!q.isEmpty()){
             int a=q.poll();
             for(int neigh: adj.get(a)){
                 indeg[neigh]--;
                 if(indeg[neigh]==0) q.add(neigh);
             }
             st.push(a);
         }
         if(st.size()!=n) return false;
         return true;
     }
 }