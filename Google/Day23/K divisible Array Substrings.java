class Solution {
     public int countDistinct(int[] nums, int k, int p) {
         Set<List<Integer>> hs=new HashSet<>();
         for(int i=0; i<nums.length; i++){
             List<Integer> temp=new ArrayList<>();
             for(int j=i; j<nums.length; j++){
                 temp.add(nums[j]);
                 hs.add(new ArrayList<>(temp));
             }
             temp.clear();
         }
         int ans=hs.size();
         // System.out.println(hs);
         // hs.forEach(System.out::println);
         for(List<Integer> temp: hs){
             // System.out.println(temp);
             // for(int i=0; i<hs.size(); i++){
             //     List<Integer> temp=hs.get(i);
             int l=k;
             for(int i=0; i<temp.size(); i++){
                 if(temp.get(i)%p==0) l--;
             }
             if(l<0)ans--;
         }
         return ans;
     }
 }