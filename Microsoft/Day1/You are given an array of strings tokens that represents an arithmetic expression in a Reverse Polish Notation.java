class Solution {
     public int evalRPN(String[] t) {
         Stack<Integer> st=new Stack<>();
         for(int i=0; i<t.length; i++){
             if(t[i].equals("+")||t[i].equals("-")||t[i].equals("/")||t[i].equals("*")){
                 int a=st.pop();
                 int b=st.pop();
                 int c=0;
                 if(t[i].equals("+")) 
                     c=b+a;
                 else if(t[i].equals("-"))
                     c=b-a;
                 else if(t[i].equals("/")) 
                     c=b/a;
                 else if(t[i].equals("*")) 
                     c=b*a;
                 st.add(c);
             }
             else{
                 st.add(Integer.valueOf(t[i]));
             }
         }
         return st.peek();
     }
 }