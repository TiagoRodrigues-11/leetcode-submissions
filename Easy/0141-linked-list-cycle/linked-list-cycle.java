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

    public boolean mySolution(ListNode head) {
        Set<ListNode> listNodeContains = new HashSet<>();

        while(head != null) {
            if (listNodeContains.contains(head)) {
                return true;
            }
            listNodeContains.add(head);
            head = head.next;
        }

        return false;
    }

    public boolean floydRabbitHareSolution(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;


        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public boolean hasCycle(ListNode head) {
        return floydRabbitHareSolution(head);
    }
}