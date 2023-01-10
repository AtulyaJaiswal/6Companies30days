// Modify condition to nums[i]-rev(nums[i])=nums[j]-rev(nums[j]);
// Keep storing the nums[i]-rev(nums[i]) and match with other one and count the total pairs
// Store in map diff,number of pairs having difference


class Solution {
     int mod=(int)1e9+7;
     public int countNicePairs(int[] nums) {
         Map<Integer,Integer> hm=new HashMap<>();
         int ans=0;
         for(int i=0; i<nums.length; i++){
             int number = nums[i], reverse = 0;  
             while(number != 0)   {  
                 int remainder = number % 10;  
                 reverse = reverse * 10 + remainder;  
                 number = number/10;  
             }
             int diff=nums[i]-reverse;
             // System.out.println(hm+" "+diff);
             if(hm.containsKey(diff)){
                 ans=(ans+hm.get(diff))%mod;
                 hm.put(diff,hm.get(diff)+1);
             }
             else{
                 hm.put(diff,1);
             }
         }
         return ans;
     }
 }
