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
    public ListNode mergeKLists(ListNode[] lists) {
        // Create the dummy head and the tail
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Create the heap to store the heads
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Put the heads into the heap
        for (ListNode head: lists) {
            if (head != null) pq.offer(head);
        }

        // Iteratively build the output list
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            tail.next = min;
            tail = min;

            if (min.next != null) pq.offer(min.next);
        } 

        return dummy.next;
    }
}
