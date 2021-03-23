package ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        ArrayList<Integer> preorderList = new ArrayList<Integer>(preorder.length);
        for (int i : preorder) preorderList.add(i);
        ArrayList<Integer> inorderList = new ArrayList<Integer>(inorder.length);
        for (int i : inorder) inorderList.add(i);
        return construct(preorderList, inorderList);
    }

    public TreeNode construct(List<Integer> preorder, List<Integer> inorder) {
        int size = inorder.size();
        if (size == 0) return null;
        TreeNode root = new TreeNode(preorder.get(0));
        int rootInorderIndex = inorder.indexOf(preorder.get(0));
        List<Integer> leftInorder = inorder.subList(0, rootInorderIndex);
        List<Integer> leftPreorder = preorder.subList(1, rootInorderIndex + 1);
        List<Integer> rightInorder = inorder.subList(rootInorderIndex + 1, size);
        List<Integer> rightPreorder = preorder.subList(size - rightInorder.size(), size);
        root.left = construct(leftPreorder, leftInorder);
        root.right = construct(rightPreorder, rightInorder);
        return root;
    }
}
