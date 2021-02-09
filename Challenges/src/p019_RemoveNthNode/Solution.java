package p019_RemoveNthNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = new ListNode();
        left.next=head;
        ListNode right = left;
        ListNode start = left;
        for(int i=0;i<n;i++){
            if(right.next!=null){
                right=right.next;
            }
        }
        while(right.next!=null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return start.next;
    }
}
