package p1038_BinarySearchTreeToGreaterSumTree;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/23 15:58
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to
 * the original key plus sum of all keys greater than the original key in BST.
 * Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 */
class Solution {

    Integer sum = 0;
    Integer temp = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        if (root.right != null) {
            bstToGst(root.right);
        }
        int temp = root.val + sum;
        sum += root.val;
        root.val = temp;
        if (root.left != null) {
            bstToGst(root.left);
        }
        return root;
    }
}
