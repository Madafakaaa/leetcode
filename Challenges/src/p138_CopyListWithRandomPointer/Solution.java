package p138_CopyListWithRandomPointer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 * <p>
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 * <p>
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * <p>
 * Return the head of the copied linked list.
 * <p>
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 * <p>
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 * <p>
 * Example 1:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * Example 2:
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * <p>
 * Example 3:
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 */
class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> list = new ArrayList<>();
        ArrayList<Node> resList = new ArrayList<>();
        HashMap<Node, Node> map = new HashMap<>();
        while (head != null) {
            Node newNode = new Node(head.val);
            map.put(head, newNode);
            list.add(head);
            if (!resList.isEmpty()) {
                resList.get(resList.size() - 1).next = newNode;
            }
            resList.add(newNode);
            head = head.next;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).random != null) {
                resList.get(i).random = map.get(list.get(i).random);
            }
        }
        return resList.get(0);
    }

}
