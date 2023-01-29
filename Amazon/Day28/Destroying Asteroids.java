class Solution {
     public boolean asteroidsDestroyed(int mass, int[] a) {
         Arrays.sort(a);
         long m=mass;
         for(int i=0; i<a.length; i++){
             if(m<(long)a[i]){
                 // System.out.println(mass+" "+a[i]);
                 return false;
             }
             m+=(long)a[i];
         }
         return true;
     }
 }