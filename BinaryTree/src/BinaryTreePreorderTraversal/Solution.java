package BinaryTreePreorderTraversal;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> ll = new LinkedList<>();
        if(root==null) return ll;
        ll.add(root.val);
        ll.addAll(preorderTraversal(root.left));
        ll.addAll(preorderTraversal(root.right));
        return ll;
    }
}
