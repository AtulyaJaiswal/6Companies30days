// Using two heaps-one max and one min
// keep storing and calculating to get ans;

class Solution {
     public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
         int n = profits.length;
         PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(n, (i1, i2) -> capital[i1] - capital[i2]);
         PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(n, (i1, i2) -> profits[i2] - profits[i1]);
         for (int i = 0; i < n; i++) {
             minCapitalHeap.offer(i);
         } 
         int availableCapital = w;
         for (int i = 0; i < k; i++) {
             while (!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= availableCapital){
                 maxProfitHeap.offer(minCapitalHeap.poll());
             }
             if (maxProfitHeap.isEmpty()) {
                 break;
             }
             availableCapital += profits[maxProfitHeap.poll()];
         }
         return availableCapital;
     }
 }