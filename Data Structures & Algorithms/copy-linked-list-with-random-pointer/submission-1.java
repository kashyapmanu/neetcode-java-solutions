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
        if (head == null) return null;
        Node copyHead = new Node(head.val);
        Node copyTail = copyHead;
        Node curr = head.next;

        while (curr != null) {
            copyTail.next = new Node(curr.val);
            copyTail = copyTail.next;
            curr = curr.next;
        }

        curr = head;
        Node currCopy = copyHead;

        while (curr != null) {
            if (curr.random != null) {
                int index = 0;
                Node seek = head;
                Node target = copyHead;
                while (seek != curr.random) {
                    seek = seek.next;
                    index++;
                }
                for (int i = 0; i < index; i++) {
                    target = target.next;
                }
                currCopy.random = target;
            }
            curr = curr.next;
            currCopy = currCopy.next;
        }

        return copyHead;
    }
}
