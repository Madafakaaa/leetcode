package DesignLinkedList;

class MyLinkedList {

    private ListNode head;
    private int size;
    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        ListNode res = head;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val, head);
        this.head = newNode;
        this.size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(val);
        this.size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        ListNode newNode = new ListNode(val, temp.next);
        temp.next = newNode;
        head = dummy.next;
        this.size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index > size) {
            return;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        head = dummy.next;

    }

    public class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int val, ListNode next, ListNode prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}