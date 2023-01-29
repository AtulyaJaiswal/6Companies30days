class Solution {
     public List<List<String>> mostPopularCreator(String[] c, String[] id, int[] v) {
         List<List<String>> ans=new ArrayList<>();
         Map<String,Long> hm=new HashMap<>();
         Map<String,Integer> hm1=new HashMap<>();
         Map<String,String> hm2=new HashMap<>();
         long max=0;
         for(int i=0; i<c.length; i++){
             if(hm1.containsKey(c[i])) continue;
             else hm1.put(c[i],0);
         }
         for(int i=0; i<c.length; i++){
             if(hm.containsKey(c[i])){
                 hm.put(c[i],(long)hm.get(c[i])+(long)v[i]);
                 if(hm.get(c[i])>max) max=hm.get(c[i]);
                 if(hm1.get(c[i])==v[i]){
                     String s=hm2.get(c[i]);
                     int x=s.compareTo(id[i]);
                     if(x<=0) continue;
                     else hm2.put(c[i],id[i]);
                 }
                 else if(v[i]>hm1.get(c[i])){
                     hm1.put(c[i],v[i]);
                     hm2.put(c[i],id[i]);
                 }
             }
             else{
                 if(v[i]>max) max=v[i];
                 hm.put(c[i],(long)v[i]);
                 hm1.put(c[i],v[i]);
                 hm2.put(c[i],id[i]);
             }
         }
         for(Map.Entry<String,Long> map: hm.entrySet()){
             if(map.getValue()==max){
                 List<String> temp=new ArrayList<>();
                 temp.add(map.getKey());
                 temp.add(hm2.get(map.getKey()));
                 ans.add(new ArrayList<>(temp));
             }
         }
         return ans;
     }
 }
 