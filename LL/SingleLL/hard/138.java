

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Map to hold original node → copied node
        Map<Node, Node> map = new HashMap<>();

        // 1st pass: copy nodes and next pointers
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // 2nd pass: assign next & random
        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
