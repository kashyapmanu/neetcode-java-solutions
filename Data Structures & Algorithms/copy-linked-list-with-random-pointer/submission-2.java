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
        /*
        Create an identity map from original node to its freshly minted copy.
        Walk the orginal ll creating the copy ll along with next and random nodes
        taken from the identity map.
        */

        Map<Node, Node> iMap = new HashMap<>();

        // Creating the identity map.
        Node curr = head;
        while (curr != null) {
            iMap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Creating the copy ll
        curr = head;
        Node copy = iMap.get(curr);

        while (curr != null) {
            copy.next = iMap.get(curr.next);
            copy.random = iMap.get(curr.random);
            copy = copy.next;
            curr = curr.next;
        }

        return iMap.get(head);
    }
}
