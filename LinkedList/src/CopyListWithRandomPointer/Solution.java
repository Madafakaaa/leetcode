package CopyListWithRandomPointer;

import java.util.ArrayList;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> nodes = new ArrayList<>();
        ArrayList<Integer> randomIndex = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        for (Node n : nodes) {
            randomIndex.add(nodes.indexOf(n.random));
        }
        ArrayList<Node> copy = new ArrayList<>();
        for (Node n : nodes) {
            copy.add(new Node(n.val));
        }
        for (int i = 0; i < copy.size(); i++) {
            if (randomIndex.get(i) != -1)
                copy.get(i).random = copy.get(randomIndex.get(i));
        }
        for (int i = 0; i < copy.size() - 1; i++) {
            copy.get(i).next = copy.get(i + 1);
        }
        return copy.get(0);
    }
}