package ConstructBinaryTreeFromInorderAndPostorderTraversal;

import java.util.ArrayList;
import java.util.List;

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        ArrayList<Integer> inorderList = new ArrayList<Integer>(inorder.length);
        for (int i : inorder) inorderList.add(i);
        ArrayList<Integer> postorderList = new ArrayList<Integer>(postorder.length);
        for (int i : postorder) postorderList.add(i);
        return construct(inorderList, postorderList);
    }

    public TreeNode construct(List<Integer> inorder, List<Integer> postorder) {
        int size = inorder.size();
        if (size == 0) return null;
        TreeNode root = new TreeNode(postorder.get(size - 1));
        int rootInorderIndex = inorder.indexOf(postorder.get(size - 1));
        List<Integer> rightInorder = inorder.subList(rootInorderIndex + 1, size);
        List<Integer> leftInorder = inorder.subList(0, rootInorderIndex);
        List<Integer> rightPostorder = postorder.subList(size - 1 - rightInorder.size(), size - 1);
        List<Integer> leftPostorder = postorder.subList(0, size - 1 - rightInorder.size());
        root.left = construct(leftInorder, leftPostorder);
        root.right = construct(rightInorder, rightPostorder);
        return root;
    }
}