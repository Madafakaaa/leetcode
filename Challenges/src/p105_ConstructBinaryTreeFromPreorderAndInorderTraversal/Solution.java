package p105_ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.Arrays;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * Example 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        } else if (preorder.length == 1) {
            return new TreeNode(preorder[0], null, null);
        } else {
            int leftCount = 0;
            while (inorder[leftCount] != preorder[0]) {
                leftCount++;
            }
            int[] leftPre = Arrays.copyOfRange(preorder, 1, leftCount + 1);
            int[] rightPre = Arrays.copyOfRange(preorder, leftCount + 1, preorder.length);
            int[] leftIn = Arrays.copyOfRange(inorder, 0, leftCount);
            int[] rightIn = Arrays.copyOfRange(inorder, leftCount + 1, preorder.length);
            return new TreeNode(preorder[0], buildTree(leftPre, leftIn), buildTree(rightPre, rightIn));
        }
    }
}