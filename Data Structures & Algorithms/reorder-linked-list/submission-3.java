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
        /*
        - Idea
        - Find the middle of the ll using fast and slow p.
        - Break the ll in the middle.
        - Merge the first and second half of ll alternatively.
        */

        // If the ll is null then nothing to do
        if (head == null || head.next == null) return;

        // Find the middle of the ll and break it into first and second halves.
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        ListNode first = head;
        slow.next = null;

        // Reverse the second half.
        ListNode prev = null;
        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }
        second = prev;

        // Merge the first and second half;
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }

        


    }
}
