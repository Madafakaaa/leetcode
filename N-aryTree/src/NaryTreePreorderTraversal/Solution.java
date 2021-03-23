package NaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> list = new ArrayList<Integer>();

    public List<Integer> preorder(Node root) {
        if (root == null) return list;
        helper(root);
        return list;
    }

    public void helper(Node root) {
        list.add(root.val);
        for (Node n : root.children) helper(n);
    }

}