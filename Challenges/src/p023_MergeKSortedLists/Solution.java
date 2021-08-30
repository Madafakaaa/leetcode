package p023_MergeKSortedLists;

import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * Example 1:
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 * <p>
 * Input: lists = []
 * Output: []
 * Example 3:
 * <p>
 * Input: lists = [[]]
 * Output: []
 */
public class Solution {

    PriorityQueue<ListNode> heap;

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            while (node != null) {
                heap.add(node);
                node = node.next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (!heap.isEmpty()) {
            temp.next = heap.poll();
            temp = temp.next;
        }
        temp.next = null;
        return dummy.next;
    }
}
