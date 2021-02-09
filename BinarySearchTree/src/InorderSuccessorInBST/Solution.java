package InorderSuccessorInBST;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null||p==null) return null;
        List<TreeNode> list = inorderTraversal(root);
        int index = list.indexOf(p);
        if(index+1==list.size()) return null;
        return list.get(index+1);
    }


    public List<TreeNode> inorderTraversal(TreeNode node){
        List<TreeNode> l = new ArrayList<>();
        if(node.left!=null) l.addAll(inorderTraversal(node.left));
        l.add(node);
        if(node.right!=null) l.addAll(inorderTraversal(node.right));
        return l;
    }

}