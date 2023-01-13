class Solution {
     HashMap<Integer, Integer> map = new HashMap<>();
     public int findIntegers(int n) {
         if(n == 1 || n == 2) return n+1;
         
         int s = nextPowerOf2(n);
         int h = highestPowerof2(n);
         if(h == n) return help(h) + 1;
 
         int temp = h + (s - h) / 2;
         if(n >= temp) return help(s);
         
         return help(h) + findIntegers(n - h);
     }
     
     int help(int n) {
         if(n == 1 || n == 2) return n; 
         if(map.containsKey(n)) return map.get(n);
         int res = help(n / 2) + help(n / 4);
         map.put(n, res);
         return res;
     }
     
     int highestPowerof2(int n) {
         
         int p = (int)(Math.log(n) / Math.log(2));
         return (int)Math.pow(2, p);
         
     }
     
     int nextPowerOf2(int n) {
         int p = 1;
         if (n > 0 && (n & (n - 1)) == 0)
             return n;
  
         while (p < n)
             p <<= 1;
      
         return p;
     }
     
     
} 
