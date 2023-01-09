// Treverse -> Fill -> Sort -> Return

class Solution {
     public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
         List<Integer> list=new ArrayList<>();
         f(root1,list);
         f(root2,list);
         Collections.sort(list);
         return list;
     }
     public void f(TreeNode root, List<Integer> list){
         if(root==null) return;
         list.add(root.val);
         f(root.left,list);
         f(root.right,list);
     }
 }