// Binary Indexed Tree concept applied 
// learnt a new thing


class Solution {    
     public long goodTriplets(int[] nums1, int[] nums2) {
         int n = nums1.length;
         int[] arr = new int[n];
         HashMap<Integer, Integer> map = new HashMap<>();
         for(int i = 0; i < n; i++){
             map.put(nums1[i], i);
         }
         for(int i = 0; i < n; i++){
             arr[i] = map.get(nums2[i]);
         }
         long ans = 0;
         long cnt = 0;
         for(int i = 0; i < n; i++){
             for(int j = i+1; j < n; j++){
                 for(int k = j+1; k < n; k++){
                     if(arr[i] < arr[j] && arr[j] < arr[k]) ans++;
                     cnt++;
                 }
             }
         }
         return ans;
     }
 }