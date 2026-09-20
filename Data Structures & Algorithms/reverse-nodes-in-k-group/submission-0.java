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
        /*
         * Create an arraylist to store each node references so that they can  be manipulated
         * independently.
         */
        List<ListNode> nodes = new ArrayList<>();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            nodes.add(curr);
        }
        int n = nodes.size();

        if (k > n) {
            return head;
        }

        if (n == 0) {
            return null;
        }

        /*
         * Reverse the array in chunks of size k
         */
        for (int start = 0; start + k <= n; start += k) {
            int i = start;
            int j = start + k - 1;
            while (i < j) {
                ListNode temp = nodes.get(i);
                nodes.set(i, nodes.get(j));
                nodes.set(j, temp);
                i++;
                j--;
            }
        }

        /*
         * Reversing in done so re-wire the nodes
         */
        for (int i = 0; i < n - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }

        /*
         * Rewiring is done so terminate the end
         */
        nodes.get(n - 1).next = null;

        return nodes.get(0);
    }
}
