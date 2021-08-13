package p230_KthSmallestElementBST;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
 * <p>
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * <p>
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 */
class Solution {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorderTraverse(list, root);
        return list.get(k - 1);
    }

    public void inorderTraverse(List<Integer> list, TreeNode node) {
        if (node == null) return;
        inorderTraverse(list, node.left);
        list.add(node.val);
        inorderTraverse(list, node.right);
    }

}