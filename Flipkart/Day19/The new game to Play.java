// PROBABILTY

class Solution {
     public double new21Game(int N, int K, int W) {
         // Corner cases.
         if (K == 0) return 1;
         
         int maxPoint = K + W - 1;
         // probability[i] is probability of getting point i.
         double[] probability = new double[maxPoint + 1];
         
         probability[0] = 1;
         for (int i = 1; i <= maxPoint; i++) {
             for (int w = 1; w <= W; w++) {
                 if (i - w >= 0 && i - w < K)
                     probability[i] += probability[i - w] * 1 / W;
             }
         }
         
         double targetProbability = 0; // Probability of N or less points.
         for (int i = K; i <= N; i++) {
             targetProbability += probability[i];
         }
         
         return targetProbability;
     }
 }