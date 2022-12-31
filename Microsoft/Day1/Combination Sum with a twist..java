public class Solution {
     public List<List<Integer>> combinationSum3(int k, int n) {
          List<List<Integer>> ans=new ArrayList<>();
          int sum=0;
          for(int i=1; i<=k; i++){
              sum+=i;
          }
          if(sum>n) return ans;
          List<Integer> temp=new ArrayList<>(); 
          f(k,n,1,ans,temp,0);
          return ans;
      }
      public void f(int k, int n, int i, List<List<Integer>> ans, List<Integer> temp, int sum){
          if(temp.size()==k){
              if(sum==n) ans.add(new ArrayList<>(temp));
              return;
          }
          if(i>9) return;
          temp.add(i);
          sum+=i;
          f(k,n,i+1,ans,temp,sum);
          sum-=temp.get(temp.size()-1);
          temp.remove(temp.size()-1);
          f(k,n,i+1,ans,temp,sum);
          return;
      }
}
