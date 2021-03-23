package NaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> list = new ArrayList<Integer>();

    public List<Integer> postorder(Node root) {
        if (root == null) return list;
        helper(root);
        return list;
    }

    public void helper(Node root) {
        for (Node n : root.children) helper(n);
        list.add(root.val);
    }
}