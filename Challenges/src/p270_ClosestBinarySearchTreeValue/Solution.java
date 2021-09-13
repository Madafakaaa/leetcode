package p270_ClosestBinarySearchTreeValue;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/13 20:35
 */
class Solution {
    public int closestValue(TreeNode root, double target) {
        int val;
        int closest = root.val;
        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
            root = target < root.val ? root.left : root.right;
        }
        return closest;
    }
}
