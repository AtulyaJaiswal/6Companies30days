// We find individual area of rectangle and keep adding them
// We store all the extreme coordinates in a set and keep it updating if another extreme is found
// We calculate final area using extreme coordinates and if it matches the total of individual area then ans is possible


class Solution {
     public boolean isRectangleCover(int[][] rec) {
         int area=0;
         Set<String> set=new HashSet<>();
         int maxX=Integer.MIN_VALUE;
         int maxY=Integer.MIN_VALUE;
         int minX=Integer.MAX_VALUE;
         int minY=Integer.MAX_VALUE;
         for(int i=0; i<rec.length; i++){
             int x1=rec[i][0];
             int y1=rec[i][1];
             int x2=rec[i][2];
             int y2=rec[i][3];
 
             area+=((x2-x1)*(y2-y1));
 
             maxX=Math.max(maxX,x2);
             maxY=Math.max(maxY,y2);
             minX=Math.min(minX,x1);
             minY=Math.min(minY,y1);
 
             String bLeft=x1+","+y1;
             String tLeft=x1+","+y2;
             String bRight=x2+","+y1;
             String tRight=x2+","+y2;
 
             check(set,bLeft);
             check(set,tLeft);
             check(set,bRight);
             check(set,tRight);
         }
 
         String fbLeft=minX+","+minY;
         String ftLeft=minX+","+maxY;
         String fbRight=maxX+","+minY;
         String ftRight=maxX+","+maxY;
 
         if(set.size()!=4 || !set.contains(fbLeft) || !set.contains(fbRight) || 
             !set.contains(ftLeft) || !set.contains(ftRight)){
                 return false;
         }
 
         int completeArea=(maxX-minX)*(maxY-minY);
         if(completeArea!=area) return false;
         else return true;
     }
     public static void check(Set<String> set,String p){
         if(set.contains(p)){
             set.remove(p);
         }
         else{
             set.add(p);
         }
     }
 }