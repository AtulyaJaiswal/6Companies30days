// BRUTE FORCE -> N^3

class Solution {
     public int distinctEchoSubstrings(String text) {
         Set<String> hs=new HashSet<>();
         for(int i=0; i<text.length()-2; i++){
             for(int j=i+2; j<=text.length(); j+=2){
                 // System.out.println(i+" "+j);
                 if(text.substring(i,(i+j)/2)
                 .equals(text.substring((i+j)/2,j))){
                     // System.out.println(text.substring(i,(i+j)/2));
                     hs.add(text.substring(i,(i+j)/2));
                 }
             }
         }
         return hs.size();
     }
}

// SLIDING WINDOW -> N^2
public int distinctEchoSubstrings(String s) {
	Set<String> set = new HashSet<>();
	for (int len = 1; len <= s.length() / 2; len++) {
		for (int l = 0, r = len, count = 0; l < s.length() - len; l++, r++) {
			if (s.charAt(l) == s.charAt(r)) count++;
			else count = 0;

			if (count == len) {
				set.add(s.substring(l - len + 1, l + 1));
				count--;
			}
		}
	}

	return set.size();
}
