/*Node class  used in the program
class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}
*/
/*  Function which returns the  root of
    the flattened linked list. */
class GfG {
    Node flatten(Node root) {
        // Base case
        if (root == null || root.next == null)
            return root;

        // Recur for list on right
        root.next = flatten(root.next);

        // Merge current list with next list
        root = merge(root, root.next);

        return root;
    }

    Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        result.next = null; // Important: remove next pointers
        return result;
    }
}
