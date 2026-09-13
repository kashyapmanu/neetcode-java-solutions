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
        /* Collect the proper representations of the numbers */
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (ListNode l1 = n; n != null; n = n.next) {
            s1.append(n.val);
        }

        for (ListNode l2 = n; n != null; n = n.next) {
            s1.append(n.val);
        }

        BigInteger a = new BigInteger(s1.reverse().toString());
        BigInteger b = new BigInteger(s2.reverse().toString());
        BigInteger sum = a.add(b);

        String digits = sum.toString();

        ListNode result = new ListNode(0);
        ListNode tail = result;

        for (int i = digits.length(); i >= 0; i--) {
            tail.next = new ListNode(digits.charAt(i) - '0');
            tail = tail.next;
        }

        return result.next;
    }
}
