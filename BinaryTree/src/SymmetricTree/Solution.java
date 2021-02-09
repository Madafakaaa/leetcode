package SymmetricTree;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;
        if(root.left!=null&&root.right!=null) {
            if(inorderTraversal(root).toString().equals(inorderTraversalReversed(root).toString())){
                return true;
            }
        }
        return false;

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> ll = new LinkedList<>();
        if(root==null){
            ll.add(0);
            return ll;
        }
        ll.add(root.val);
        ll.addAll(inorderTraversal(root.left));
        ll.addAll(inorderTraversal(root.right));
        return ll;
    }

    public List<Integer> inorderTraversalReversed(TreeNode root) {
        LinkedList<Integer> ll = new LinkedList<>();
        if(root==null){
            ll.add(0);
            return ll;
        }
        ll.add(root.val);
        ll.addAll(inorderTraversalReversed(root.right));
        ll.addAll(inorderTraversalReversed(root.left));
        return ll;
    }
}
