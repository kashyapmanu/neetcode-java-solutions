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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Reverse a ll in groups of size k

        // Create a dummy head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Create a dummy group prev
        ListNode groupPrev = dummy;

        // Start the reversing in groups process
        while (true) {
            // Find the kth node for the group
            ListNode kth = groupPrev;

            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            // Come out once group cant be formed
            if (kth == null)
                break;

            // Bookmark the next after group end
            ListNode groupNext = kth.next;

            // We got the group now reverse the group while making sure the tail points to the next
            // group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // The groupPrev still points to the old first fix it and reposition the groupPrev
            ListNode oldFirst = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = oldFirst;
        }

        return dummy.next;
    }
}
