// Solved using take/notTake technique
// and later applying memoisation


class Solution {
     public List<Integer> largestDivisibleSubset(int[] nums) {
         Arrays.sort(nums);
         ArrayList<Integer> ans=new ArrayList<Integer>();
         ArrayList<Integer> temp=new ArrayList<>();
         int dp[]=new int[nums.length+1];
         Arrays.fill(dp,-1);
         f(0,1,nums,ans,temp,dp);
         return ans;
     }
     public void f(int i, int prev, int[] nums, ArrayList<Integer> ans, ArrayList<Integer> temp, int[] dp){
         // System.out.println(temp);
         if(i==nums.length){
             if(temp.size()>ans.size()){
                 ans.clear();
                 ans.addAll(temp);
             }
             return;
         }
         if(temp.size()>dp[i] &&  //IMPORTANT
               (nums[i]%prev==0||prev%nums[i]==0)){
             dp[i]=temp.size(); //IMPORTANT
             temp.add(nums[i]);
             f(i+1,nums[i],nums,ans,temp,dp);
             temp.remove(temp.size()-1);
         }
         f(i+1,prev,nums,ans,temp,dp);
         return;
     }
 }
