package p1008_ConstructBinarySearchTreeFromPreorderTraversal;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/10/13 17:33
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode newNode = new TreeNode(preorder[start]);
        if (start != end) {
            int i = start + 1;
            while (i <= end && preorder[start] > preorder[i]) {
                i++;
            }
            newNode.left = helper(preorder, start + 1, i - 1);
            newNode.right = helper(preorder, i, end);
        }
        return newNode;
    }
}
