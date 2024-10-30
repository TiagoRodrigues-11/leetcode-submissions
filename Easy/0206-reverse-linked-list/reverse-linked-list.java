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

    public ListNode recursivelyReverseList(ListNode head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively call
        ListNode newNode = recursivelyReverseList(head.next);

        head.next.next = head;
        head.next = null;
    
        return newNode;
    }

    public ListNode iterativelyReverseList(ListNode head) {
        ListNode prev = null;

        while(head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }

        return prev;
    }

    public ListNode reverseList(ListNode head) {
        return iterativelyReverseList(head);    
        //return recursivelyReverseList(head);
    }
}