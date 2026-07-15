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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to sit before the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Pass 1 - Count the total nodes
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // Walk to the node just before the target and unlink the target node.
        ListNode prev = dummy;
        for (int i = 0; i < length - n; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;

        return dummy.next;
    }
}
