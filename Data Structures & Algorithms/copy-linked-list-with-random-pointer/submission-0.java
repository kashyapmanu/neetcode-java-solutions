/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // First pass: copying the orginal ll
        Node copyHead = new Node(head.val);
        Node copyTail = copyHead;
        Node curr = head.next;

        while (curr != null) {
            copyTail.next = new Node(curr.val);
            copyTail = copyTail.next;
            curr = curr.next;
        }

        // Second pass: copying the random pointers
        curr = head;
        Node copyCurr = copyHead;

        while (curr != null) {
            if (curr.random != null) {
                int index = 0;
                Node scannerNode = head;
                while (scannerNode != curr.random) {
                    scannerNode = scannerNode.next;
                    index++;
                }
                Node target = copyHead;
                for (int i = 0; i < index; i++) {
                    target = target.next;
                }
                copyCurr.random = target;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;
    }
}
