class Solution {
     // O(N) -> two pointers approach
     public int findUnsortedSubarray(int[] nums) {
         int max=nums[0],min=nums[nums.length-1],left=-1,right=-1;
         for(int i=0; i<nums.length; i++){
             if(max>nums[i]) right=i;
             max=Math.max(max,nums[i]);
         }
         for(int i=nums.length-1; i>=0; i--){
             if(min<nums[i]) left=i;
             min=Math.min(min,nums[i]);
         }
         if(right==-1||left==-1) return 0;
         return right-left+1;
     }
     // O(NlogN) -> sort and compare
     public int findUnsortedSubarray(int[] nums) {
         int temp[]=new int[nums.length];
         for(int i=0; i<nums.length; i++){
             temp[i]=nums[i];
         }
         Arrays.sort(temp);
         int start=0,end=0,flag=0;
         for(int i=0; i<nums.length; i++){
             if(flag==0 && temp[i]!=nums[i]){
                 flag=1;
                 start=i;
             }
             else if(temp[i]!=nums[i]) end=i;
         }
         if(end==0) return 0;
         return end-start+1;
     }
 }