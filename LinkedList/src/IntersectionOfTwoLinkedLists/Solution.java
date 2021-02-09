package IntersectionOfTwoLinkedLists;

import java.util.HashSet;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> nodes = new HashSet<>();
        ListNode tempA = headA;
        while(tempA!=null){
            nodes.add(tempA);
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while(tempB!=null){
            if(nodes.contains(tempB)){
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }

}