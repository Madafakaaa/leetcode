package p124_BinaryTreeMaximumPathSum;

class Solution {

    public int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if(root!=null) recur(root);
        return maxSum;
    }

    public int recur(TreeNode node){
        int res = node.val;
        int leftVal = 0;
        int rightVal = 0;
        if(node.left!=null){
            leftVal = recur(node.left);
            if(leftVal>0) res += leftVal;
        }
        if(node.right!=null) {
            rightVal = recur(node.right);
            if (rightVal > 0) res += rightVal;
        }
        if(res > this.maxSum)  maxSum = res;
        // return res;
        // for recursion : return the max gain if continue the same path?????
        return node.val+Math.max(Math.max(leftVal,0),Math.max(rightVal,0));
    }
}