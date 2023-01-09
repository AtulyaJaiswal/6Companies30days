// Pehle split krke store
// agar naam same mile to compare kr lo if invalid to add krte jaao


class Solution {
     public List<String> invalidTransactions(String[] t) {
         Set<Integer> ans=new HashSet<>();
         Map<String,List<Integer>> hm=new HashMap<>();
         String[][] sp=new String[t.length][4];
         for(int i=0; i<t.length; i++){
             String[] temp=t[i].split(",");
             for(int j=0; j<4; j++){
                 sp[i][j]=temp[j];
             }
         }
         for(int i=0; i<t.length; i++){
             // System.out.println(ans);
             int flag=0;
             if(Integer.valueOf(sp[i][2])>1000) ans.add(i);
             if(hm.containsKey(sp[i][0])){
                 List<Integer> l=hm.get(sp[i][0]);
                 for(int j=0; j<l.size(); j++){
                     int x=l.get(j);
                     int a=Integer.valueOf(sp[i][1]);
                     int b=Integer.valueOf(sp[x][1]);
                     // System.out.println(a+" "+b);
                     if(Math.abs(b-a)<=60 && sp[i][3].equals(sp[x][3])==false){
                         ans.add(i);
                         ans.add(x);
                     }
                 }
             }
             if(hm.get(sp[i][0])!=null){
                 List<Integer> l=hm.get(sp[i][0]);
                 l.add(i);
                 hm.put(sp[i][0],l);
             }
             else{
                 List<Integer> l=new ArrayList<>();
                 l.add(i);
                 hm.put(sp[i][0],new ArrayList<>(l));
             }
         }
         List<String> fans=new ArrayList<>();
         for(Integer z: ans){
             fans.add(t[z]);
         }
         return fans;
     }
 }