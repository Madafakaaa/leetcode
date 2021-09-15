package 剑指Offer.剑指Offer07_重建二叉树;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 13:47
 */

import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int leftCount = 0;
        while (inorder[leftCount] != preorder[0]) {
            leftCount++;
        }
        TreeNode node = new TreeNode(preorder[0]);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + leftCount), Arrays.copyOfRange(inorder, 0, leftCount));
        node.right = buildTree(Arrays.copyOfRange(preorder, 1 + leftCount, preorder.length), Arrays.copyOfRange(inorder, 1 + leftCount, preorder.length));
        return node;
    }
}
