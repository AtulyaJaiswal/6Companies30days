// Good Ques of Disjoint Set

class DisjointSet{
     List<Integer> parent=new ArrayList<>();
     List<Integer> rank=new ArrayList<>();
     List<Integer> size=new ArrayList<>();
     public DisjointSet(int n){
         for(int i=0; i<=n; i++){
             parent.add(i);
             rank.add(0);
             size.add(1);
         }
     }
     public int findPar(int node){
         if(parent.get(node)==node) return node;
         
         parent.set(node,findPar(parent.get(node)));
         return parent.get(node);
     }
     public void unionByRank(int u, int v){
         int ulp_u=findPar(u);
         int ulp_v=findPar(v);
         if(ulp_u==ulp_v) return;
         if(rank.get(ulp_u)<rank.get(ulp_v))
             parent.set(ulp_u,ulp_v);
         else if(rank.get(ulp_u)>rank.get(ulp_v))
             parent.set(ulp_v,ulp_u);
         else{
             parent.set(ulp_v,ulp_u);
             rank.set(ulp_u,rank.get(ulp_u)+1);
         }
     }
     public void unionBySize(int u, int v){
         int ulp_u=findPar(u);
         int ulp_v=findPar(v);
         if(ulp_u==ulp_v) return;
         if(size.get(ulp_u)<size.get(ulp_v)){
             parent.set(ulp_u,ulp_v);
             size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
         }
         else{
             parent.set(ulp_v,ulp_u);
             size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
         }
         // return;
     }
   }
   
   class Solution {
       public boolean isValid(int i, int j, int[][] grid){
           int n=grid.length;
           int m=grid[0].length;
           if(i>=0 && j>=0 && i<n && j<m) return true;
           return false;
       }
       public int maxAreaOfIsland(int[][] grid) {
           int n=grid.length;
           int m=grid[0].length;
           int vis[][]=new int[n][m];
           DisjointSet ds=new DisjointSet(n*m);
           for(int i=0; i<n; i++){
               for(int j=0; j<m; j++){
                   if(grid[i][j]==0) continue;
                   int dr[]={1,-1,0,0};
                   int dc[]={0,0,1,-1};
                   for(int ind=0; ind<4; ind++){
                       int newr=i+dr[ind];
                       int newc=j+dc[ind];
                       if(isValid(newr,newc,grid) && grid[newr][newc]==1){
                           // System.out.println(i+" "+j+" "+newr+" "+newc);
                           vis[newr][newc]=1;
                           int node=i*m+j;
                           int adjNode=newr*m+newc;
                           if(ds.findPar(node)!=ds.findPar(adjNode)){
                               // System.out.println(node+" "+adjNode);
                               ds.unionBySize(node,adjNode);
                           }
                       }
                   }
               }
           }
           int max=0;
           for(int i=0; i<n*m; i++){
               // System.out.println(i+" "+ds.findPar(i));
               if(ds.size.get(ds.findPar(i))>max) max=ds.size.get(ds.findPar(i));
           }
           for(int i=0; i<n; i++){
               for(int j=0; j<m; j++){
                   if(grid[i][j]==1) return max;
               }
           }
           return 0;
       }
   }