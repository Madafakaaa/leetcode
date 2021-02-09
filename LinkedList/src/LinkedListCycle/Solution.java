package LinkedListCycle;

import java.util.HashSet;

public class Solution {

    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        HashSet<ListNode> hashcodes = new HashSet();
        ListNode temp = head;
        ListNode temp2 = head;
        while(temp.next!=null){
            if(hashcodes.contains(temp.next)){
                return true;
            }
            hashcodes.add(temp.next);
            temp = temp.next;
        }
        return false;
    }
}