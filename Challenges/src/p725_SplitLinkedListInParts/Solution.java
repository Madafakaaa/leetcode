package p725_SplitLinkedListInParts;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/29 23:40
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int[] sizes = new int[k];
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        for (int i = 0; i < length; i++) {
            sizes[i % k]++;
        }
        for (int i = 0; i < k; i++) {
            res[i] = head;
            if (head == null) {
                break;
            }
            for (int j = 0; j < sizes[i] - 1; j++) {
                head = head.next;
            }
            temp = head.next;
            head.next = null;
            head = temp;
        }
        return res;
    }
}
