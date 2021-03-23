package MaximumDepth;

class Solution {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int maxChildDepth = -1;
        for (Node n : root.children) {
            int childDepth = maxDepth(n);
            maxChildDepth = childDepth > maxChildDepth ? childDepth : maxChildDepth;
        }
        return maxChildDepth + 1;
    }

}