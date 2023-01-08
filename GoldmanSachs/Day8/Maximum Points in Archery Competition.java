// recursively badhte jao aur jb max point jyada ho jaaye to main array update or else aage badhte jaao
// take/not take technique used
// filling part is tricky
// keval max nikaalna hota to can use memoization and dp --easy


class Solution {
     int fmax=0;
     int fBob[]=new int[12];
     public int[] maximumBobPoints(int num, int[] al) {
         int bob[]=new int[12];
         f(num,bob,al,11,0);
         return fBob;
     }
     public void f(int n, int[] b, int[] a, int i, int max){
         if(n==0 || i<0){
             if(n>0) b[0]+=n;
             if(max>fmax){
                 fmax=max;
                 fBob=b.clone();
             }
             return;
         }
         if(n>a[i]){
             b[i]=a[i]+1;
             f(n-a[i]-1,b,a,i-1,max+i);
             b[i]=0;
         }
         f(n,b,a,i-1,max);
         b[i]=0;
     }
 }
