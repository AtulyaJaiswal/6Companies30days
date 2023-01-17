class Solution {
     public ListNode removeZeroSumSublists(ListNode head) {
         ListNode cur=head;
         ListNode dummy = new ListNode(0);
         dummy.next=head;
         Map<Integer,ListNode> hm=new HashMap<>();
         hm.put(0,dummy);
         int sum=0;
         while(cur!=null){
             sum+=cur.val;
             if(hm.containsKey(sum)){
                 ListNode oldNodeWithSameSum = hm.get(sum); 
                 ListNode toBeRemovedNode = oldNodeWithSameSum.next;
                 int toBeRemovedSum = sum;
                 while(toBeRemovedNode != cur){
                     toBeRemovedSum += toBeRemovedNode.val;
                     hm.remove(toBeRemovedSum);
                     toBeRemovedNode = toBeRemovedNode.next;
                 }
                 oldNodeWithSameSum.next = cur.next;
             }
             else{
                 hm.put(sum,cur);
             }
             cur=cur.next;
         }
         return dummy.next;
     }
 }
     
}
