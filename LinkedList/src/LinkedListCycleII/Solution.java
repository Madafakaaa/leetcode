package LinkedListCycleII;

import java.util.HashSet;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        HashSet<ListNode> nodes = new HashSet();
        ListNode temp = head;
        while(temp.next!=null){
            nodes.add(temp);
            if(nodes.contains(temp.next)){
                return temp.next;
            }
            temp = temp.next;
        }
        return null;
    }
}