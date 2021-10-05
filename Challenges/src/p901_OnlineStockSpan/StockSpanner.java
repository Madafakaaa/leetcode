package p901_OnlineStockSpan;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/4 23:44
 */
class StockSpanner {
    Node cur;

    public StockSpanner() {
        cur = null;
    }

    public int next(int price) {
        cur = new Node(price, cur);
        return cur.count;
    }
}

class Node {
    int val;
    int count;
    Node prev;

    public Node(int val, Node prev) {
        this.val = val;
        this.count = 1;
        while (prev != null && prev.val <= val) {
            count += prev.count;
            prev = prev.prev;
        }
        this.prev = prev;
    }
}
