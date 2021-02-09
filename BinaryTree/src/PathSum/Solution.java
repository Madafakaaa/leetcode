package PathSum;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private HashSet<Integer> set = new HashSet<>();

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        addPathSum(root, 0);
        if(set.contains(sum)) return true;
        return false;
    }

    public void addPathSum(TreeNode root, int sum) {
        if(root.left==null&&root.right==null){
            set.add(sum+root.val);
            return;
        }
        int newSum = sum + root.val;
        if(root.left!=null) addPathSum(root.left, newSum);
        if(root.right!=null) addPathSum(root.right, newSum);
    }

}