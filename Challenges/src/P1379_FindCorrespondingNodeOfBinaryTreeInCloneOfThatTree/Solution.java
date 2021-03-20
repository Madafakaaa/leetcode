package P1379_FindCorrespondingNodeOfBinaryTreeInCloneOfThatTree;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/20 11:15
 * <p>
 * Given two binary trees original and cloned and given a reference to a node target in the original tree.
 * <p>
 * The cloned tree is a copy of the original tree.
 * <p>
 * Return a reference to the same node in the cloned tree.
 * <p>
 * Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
 * <p>
 * Follow up: Solve the problem if repeated values on the tree are allowed.
 * <p>
 * Input: tree = [7,4,3,null,null,6,19], target = 3
 * Output: 3
 * Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.
 */
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == target) {
            return cloned;
        }
        if (original.left != null) {
            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            if (left != null) {
                return left;
            }
        }
        if (original.right != null) {
            TreeNode right = getTargetCopy(original.right, cloned.right, target);
            if (right != null) {
                return right;
            }
        }
        return null;
    }
}