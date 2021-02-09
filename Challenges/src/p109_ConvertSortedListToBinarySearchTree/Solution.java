package p109_ConvertSortedListToBinarySearchTree;

import java.util.ArrayList;

class Solution {

    public ArrayList<ListNode> nodes;

    public TreeNode sortedListToBST(ListNode head) {
        nodes = new ArrayList<>();
        while(head!=null){
            nodes.add(head);
            head = head.next;
        }
        return helper(0,nodes.size()-1);
    }

    public TreeNode helper(int left, int right){
        if(left>right) return null;
        int mid = left+(right-left)/2;
        TreeNode newNode = new TreeNode(nodes.get(mid).val);
        newNode.left = helper(left,mid-1);
        newNode.right = helper(mid+1,right);
        return newNode;
    }

}
