package RotateList;

class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode tail = head;
        int size = 1;
        while (tail.next != null) {
            size++;
            tail = tail.next;
        }
        tail.next = head;
        ListNode newHead = head;
        for (int i = 0; i < k % size; i++) {
            for (int j = 0; j < size - 1; j++) {
                newHead = newHead.next;
            }
        }
        ListNode newTail = newHead;
        for (int j = 0; j < size - 1; j++) {
            newTail = newTail.next;
        }
        newTail.next = null;
        return newHead;
    }

}