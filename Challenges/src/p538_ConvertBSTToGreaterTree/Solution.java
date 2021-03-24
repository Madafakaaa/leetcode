package p538_ConvertBSTToGreaterTree;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/24 11:17
 */
class Solution {

    int sum = 0;
    int temp = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        if (root.right != null) {
            convertBST(root.right);
        }
        int temp = root.val + sum;
        sum += root.val;
        root.val = temp;
        if (root.left != null) {
            convertBST(root.left);
        }
        return root;
    }
}
