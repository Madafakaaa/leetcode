package p437_PathSumIII;

import java.util.HashMap;

/**
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 * <p>
 * Example 1:
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * Example 2:
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 */
class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> map = process(root, targetSum);
        return map.get(targetSum);
    }


    public HashMap<Integer, Integer> process(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
        if (root == null) {
            return res;
        }
        HashMap<Integer, Integer> leftMap = process(root.left, targetSum);
        HashMap<Integer, Integer> rightMap = process(root.right, targetSum);
        res.put(root.val, 1);
        for (Integer l : leftMap.keySet()) {
            res.put(l + root.val, res.getOrDefault(l + root.val, 0) + leftMap.get(l));
        }
        for (Integer r : rightMap.keySet()) {
            res.put(r + root.val, res.getOrDefault(r + root.val, 0) + rightMap.get(r));
        }
        for (Integer l : leftMap.keySet()) {
            for (Integer r : rightMap.keySet()) {
                res.put(l + r + root.val, res.getOrDefault(l + r + root.val, 0) + leftMap.get(l) + rightMap.get(r));
            }
        }
        return res;
    }

}
