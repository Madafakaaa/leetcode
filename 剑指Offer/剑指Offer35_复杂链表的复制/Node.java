package 剑指Offer.剑指Offer35_复杂链表的复制;

class Node {
    public int val;
    public Node next;
    Node random;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}
