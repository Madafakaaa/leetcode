package p1315_SumOfNodesWittEvenValuedGrandparent;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/20 15:44
 * <p>
 * Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)
 * <p>
 * If there are no nodes with an even-valued grandparent, return 0.
 */
class Solution {

    private int res = 0;

    public int sumEvenGrandparent(TreeNode root) {
        process(root);
        return res;
    }

    public void process(TreeNode root) {
        if (root.val % 2 == 0) {
            if (root.left != null) {
                if (root.left.left != null) {
                    res += root.left.left.val;
                }
                if (root.left.right != null) {
                    res += root.left.right.val;
                }
            }
            if (root.right != null) {
                if (root.right.left != null) {
                    res += root.right.left.val;
                }
                if (root.right.right != null) {
                    res += root.right.right.val;
                }
            }
        }
        if (root.left != null) {
            process(root.left);
        }
        if (root.right != null) {
            process(root.right);
        }
    }
}
