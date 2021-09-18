package 剑指Offer.剑指Offer35_复杂链表的复制;

import java.util.HashMap;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 15:20
 */
class Solution {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node temp = dummy;
        Node tempHead = head;
        while (tempHead != null) {
            Node newNode = new Node(tempHead.val);
            map.put(tempHead, newNode);
            temp.next = newNode;
            temp = temp.next;
            tempHead = tempHead.next;
        }
        temp = dummy.next;
        tempHead = head;
        while (tempHead != null) {
            temp.random = map.get(tempHead.random);
            temp = temp.next;
            tempHead = tempHead.next;
        }
        return dummy.next;
    }

}
