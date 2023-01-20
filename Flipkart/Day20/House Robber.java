/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     public int rob(TreeNode root) {
         Map<TreeNode,Integer> hm=new HashMap<>();
         return f(root,hm);
     }
     public int f(TreeNode root, Map<TreeNode,Integer> hm){
         if(root==null) return 0;
         if(hm.containsKey(root)) return hm.get(root);
         int t=0;
         if(root.left!=null && root.right!=null)  
             t=root.val+f(root.left.left,hm)+f(root.left.right,hm)+f(root.right.left,hm)+f(root.right.right,hm);
         else if(root.left==null && root.right!=null){
             t=root.val+f(root.right.left,hm)+f(root.right.right,hm);
          }
         else if(root.right==null && root.left!=null){
             t=root.val+f(root.left.left,hm)+f(root.left.right,hm);
         }
         else t=root.val;
         int nT=f(root.left,hm)+f(root.right,hm);
         hm.put(root,Math.max(t,nT));
         return Math.max(t,nT);
     }
 }
