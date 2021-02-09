package p230_KthSmallestElementBST;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorderTraverse(list,root);
        return list.get(k-1);
    }

    public void inorderTraverse(List<Integer> list, TreeNode node){
        if(node==null) return;
        inorderTraverse(list,node.left);
        list.add(node.val);
        inorderTraverse(list,node.right);
    }

}