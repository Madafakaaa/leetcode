package p148_SortList;

class Solution {

    public ListNode sortList(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (length == 2) {
            if (head.val > head.next.val) {
                temp = head;
                head = head.next;
                head.next = temp;
                head.next.next = null;
            }
        } else if (length > 2) {
            temp = head;
            for (int i = 0; i < length / 2 - 1; i++) {
                temp = temp.next;
            }
            ListNode dummy = temp.next;
            temp.next = null;
            ListNode head1 = sortList(head);
            ListNode head2 = sortList(dummy);
            head = dummy;
            while (head1 != null && head2 != null) {
                if (head1.val < head2.val) {
                    dummy.next = head1;
                    head1 = head1.next;
                } else {
                    dummy.next = head2;
                    head2 = head2.next;
                }
            }
            while (head1 != null) {
                dummy.next = head1;
                head1 = head1.next;
            }
            while (head2 != null) {
                dummy.next = head2;
                head2 = head2.next;
            }
            head = head.next;
        }
        return head;
    }

}