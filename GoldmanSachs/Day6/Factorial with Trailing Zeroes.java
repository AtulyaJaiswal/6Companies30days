// 2 & 5 ka combination 0 deta
// to 2 jyada aaiga hi to hum 5 cnt kr lenge
// but 25 me do baar 5 aata 125 me 3 baar isliye ek loop lga lenge calculate krne ke liye

class Solution {
     public int trailingZeroes(int n) {
         int res=0;
         for(int i=5; i<=n; i=i*5){
             res=res+(n/i);
         }
         return res;
     }
 }
