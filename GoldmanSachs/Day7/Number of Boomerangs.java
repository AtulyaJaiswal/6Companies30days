// Go to every point find distance to every other point
// Count how many are same and apply n*n-1/2 to get all combination and then multiply this by 2 to get all ans as every order is counted
// O(N*2)

class Solution {
     public int numberOfBoomerangs(int[][] points) {
         int ans=0;
         if(points.length<3) return 0;
         for(int i=0; i<points.length; i++){
             Map<Double,Integer> hm=new HashMap<>();
             for(int j=0; j<points.length; j++){
                 if(i==j) continue;
                 double temp=Math.sqrt(Math.pow(points[j][0]-points[i][0],2)+Math.pow(points[j][1]-points[i][1],2));
                 if(hm.containsKey(temp)){
                     hm.put(temp,hm.get(temp)+1);
                 }
                 else hm.put(temp,1);
             }
             for(Map.Entry<Double,Integer> map: hm.entrySet()){
                 if(map.getValue()>1){
                     int a=map.getValue();
                     ans+=a*(a-1);
                 }
             }
             hm.clear();
         }
         return ans;
     }
}