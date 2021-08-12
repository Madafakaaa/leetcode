package p148_SortList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * <p>
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 * <p>
 * Example 1:
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * <p>
 * Example 2:
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * <p>
 * Example 3:
 * Input: head = []
 * Output: []
 */
class Solution {
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val > l2.val) {
                    return 1;
                } else if (l1.val < l2.val) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        while (head != null) {
            queue.add(head);
            head = head.next;
        }
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            node.next = null;
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
}