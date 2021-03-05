package p108_ConvertSortedArrayToBinarySearchTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    public TreeNode helper(int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode newNode = new TreeNode(nums[mid]);
        newNode.left = helper(left, mid - 1);
        newNode.right = helper(mid + 1, right);
        return newNode;
    }

}
