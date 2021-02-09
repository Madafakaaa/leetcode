package PopulatingNextRightPointersInEachNode;

class Solution {
    Node prev, leftMost;

    public Node connect(Node root) {
        leftMost = root;
        while (leftMost != null) {
            Node head = leftMost;
            prev = leftMost = null;
            while (head != null) {
                connectToPrev(head.left);
                connectToPrev(head.right);
                head = head.next;
            }
        }
        return root;
    }

    private void connectToPrev(Node root) {
        if (root != null) {
            if (prev == null) {
                leftMost = root; // found the leftMost
            } else {
                prev.next = root;
            }
            prev = root;
        }
    }
}