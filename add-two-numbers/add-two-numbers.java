/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null)
            return l2;
        
        if(l2 == null)
            return l1;
        
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int rem = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            
            int sum= x + y + rem;
            int value = sum % 10;
            rem = sum / 10;
            
            curr.next = new ListNode(value);
            curr = curr.next;
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        if (rem != 0) {
            curr.next = new ListNode(rem);
        }
        
        return dummyHead.next;
    }
}