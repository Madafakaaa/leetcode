package 剑指Offer.剑指Offer26_树的子结构;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/15 17:11
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recursive(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right.left, B));
    }

    public boolean recursive(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recursive(A.left, B.left) && recursive(A.right, B.right);
    }
}
