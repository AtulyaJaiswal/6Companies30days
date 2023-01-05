// simple logic se ho jaata but tricky

class Solution {
     public double nthPersonGetsNthSeat(int n) {
         if (n == 1) return 1.0d;
         return 1d / n + (n - 2d) / n * nthPersonGetsNthSeat(n - 1);
     }
     //Last me conclusion ye mila
     if(n==1){
             return 1.0;
         }
         else{
             return 0.5;
     }
 }
