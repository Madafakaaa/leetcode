package p255_VerifyPreorderSequenceInBinarySearchTree;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/9/13 19:59
 */
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE, i = -1;
        for (int p : preorder) {
            if (p < low) {
                return false;
            }
            while (i >= 0 && p > preorder[i]) {
                low = preorder[i];
                i--;
            }
            i++;
            preorder[i] = p;
        }
        return true;
    }
}
