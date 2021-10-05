package p000_Interview;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/28 13:54
 */
class Solution {

    public int FindString(String source, String pattern, Boolean ignoreCase) {
        if (source == null || source.isEmpty() || pattern == null || pattern.isEmpty() || source.length() < pattern.length() || ignoreCase == null) {
            return -1;
        }
        outLoop:
        for (int i = 0; i <= source.length() - pattern.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (!equal(source.charAt(i + j), pattern.charAt(j), ignoreCase)) {
                    continue outLoop;
                }
            }
            return i;
        }
        return -1;
    }

    public boolean equal(char i, char j, boolean ignoreCase) {
        if (ignoreCase) {
            if (i >= 'A' && i <= 'Z') {
                i = (char) (i - 'A' + 'a');
            }
            if (j >= 'A' && j <= 'Z') {
                j = (char) (j - 'A' + 'a');
            }
        }
        return i == j;
    }

}


class Node {

    Object obj;
    Node next;

    public Node() {
    }

    public Node(Object obj) {
        this.obj = obj;
    }

    public Node(Object obj, Node next) {
        this.obj = obj;
        this.next = next;
    }

}

class Queue {

    Node head;
    Node tail;
    int size;

    public Queue() {
        this.size = 0;
        head = new Node();
        tail = head;
    }

    public void add(Object obj) {
        Node newNode = new Node(obj);
        tail.next = newNode;
        tail = newNode;
        this.size++;
    }

    public Object poll() {
        if (this.size <= 0) {
            return null;
        }
        Node result = this.head.next;
        head.next = head.next.next;
        if (tail == result) {
            tail = head;
        }
        this.size--;
        return result.obj;
    }

    public int count() {
        return this.size;
    }

}
