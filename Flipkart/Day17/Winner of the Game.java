class Solution {
     public int findTheWinner(int n, int k) {
         List<Integer> l=new ArrayList<>();
         for(int i=1; i<=n; i++) l.add(i);
         int i=0;
         while(l.size()!=1){
             // System.out.println(l);
             int s=k-1;
             while(s!=0){
                 if(i>=l.size()-1) i=0;
                 else i++;
                 s--;
             }
             l.remove(i);
             if(i==l.size()) i=0;
         }
         return l.get(0);
     }
 }