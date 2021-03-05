package p023_MergeKSortedLists;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        for (int i = 0; i < lists.length - 1; i++) {
            lists[i + 1] = mergeTwoLists(lists[i], lists[i + 1]);
        }
        return lists[lists.length - 1];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0, null);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        while (l1 != null) {
            temp.next = l1;
            temp = temp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            temp.next = l2;
            temp = temp.next;
            l2 = l2.next;
        }
        return dummy.next;
    }
}
