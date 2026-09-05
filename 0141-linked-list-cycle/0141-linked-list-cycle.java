/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode sp=head;
        ListNode fp=head;
        while(fp!=null&&fp.next!=null){
            if(fp.next==sp) return true;
            sp=sp.next;
            fp=fp.next.next;
        }
        return false;
    }
}