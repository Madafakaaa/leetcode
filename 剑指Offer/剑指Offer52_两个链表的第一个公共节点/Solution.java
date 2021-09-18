package 剑指Offer.剑指Offer52_两个链表的第一个公共节点;

import java.util.HashSet;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/18 13:54
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
