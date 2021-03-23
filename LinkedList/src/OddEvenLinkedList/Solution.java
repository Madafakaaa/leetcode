package OddEvenLinkedList;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode();
        ListNode evenHead = new ListNode();
        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;
        ListNode temp = head;
        int index = 1;
        while (temp != null) {
            if (index % 2 == 1) {
                oddTail.next = temp;
                oddTail = temp;
            } else {
                evenTail.next = temp;
                evenTail = temp;
            }
            temp = temp.next;
            index++;
        }
        oddTail.next = evenHead.next;
        evenTail.next = null;
        return oddHead.next;
    }
}