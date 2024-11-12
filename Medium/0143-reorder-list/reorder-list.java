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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        ListNode prev = null;

        while (head2 != null) {
            ListNode temp2 = head2.next;
            head2.next = prev;
            prev = head2;
            head2 = temp2;
        }

        while (prev != null) {
            ListNode temp1 = head.next;
            ListNode temp2 = prev.next;

            head.next = prev;
            prev.next = temp1;

            head = temp1;
            prev = temp2;
        }
    }
}