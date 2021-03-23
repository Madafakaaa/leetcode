package FlattenAMultilevelDoublyLinkedList;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

import java.util.Stack;

class Solution {
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        while (temp != null) {
            if (temp.child != null) {
                if (temp.next != null) stack.push(temp.next);
                temp.child.prev = temp;
                temp.next = temp.child;
                temp.child = null;
            }
            if (temp.next == null && !stack.empty()) {
                Node next = stack.pop();
                next.prev = temp;
                temp.next = next;
            }
            temp = temp.next;
        }
        return head;
    }
}