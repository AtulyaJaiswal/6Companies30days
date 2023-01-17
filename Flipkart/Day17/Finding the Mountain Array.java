class Solution {
     public int findInMountainArray(int t, MountainArray m) {
         int le=m.length();
         int l=0,h=le-1;
         int mid=0;
         int res=-1;
         while(l<h){
             mid=(l+h)/2;
             if(m.get(mid)>m.get(mid+1)){
                 res=mid;
                 h=mid-1;
             }
             else l=mid+1;
         }
         // System.out.println(res);
         int a=firstHalf(t,m,res-1);
         int b=secondHalf(t,m,res);
         // System.out.println(a+" "+b);
         if(a==-1 || b==-1) return Math.max(a,b);
         return Math.min(a,b);
     }
     public int firstHalf(int t, MountainArray m, int high){
         int l=0,h=high;
         while(l<=h){
             int mid=(l+h)/2;
             int get=m.get(mid);
             if(get==t) return mid;
             else if(get>t) h=mid-1;
             else l=mid+1;
         }
         return -1;
     }
     public int secondHalf(int t, MountainArray m, int low){
         int l=low,h=m.length()-1;
         while(l<=h){
             int mid=(l+h)/2;
             int get=m.get(mid);
             if(get==t) return mid;
             else if(get<t) h=mid-1;
             else l=mid+1;
         }
         return -1;
     }
 }
