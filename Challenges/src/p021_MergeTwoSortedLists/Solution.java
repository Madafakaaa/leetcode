package p021_MergeTwoSortedLists;

class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0,null);
        ListNode temp = dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        while(l1!=null){
            temp.next = l1;
            temp = temp.next;
            l1 = l1.next;
        }
        while(l2!=null){
            temp.next = l2;
            temp = temp.next;
            l2 = l2.next;
        }
        return dummy.next;
    }

}
