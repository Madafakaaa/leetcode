package LevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> levelOrder(Node root) {
        res = new ArrayList<>();
        if(root==null) return res;
        addToList(root, 0);
        return res;
    }

    public void addToList(Node root, int depth){
        while(res.size()<(depth+1)) res.add(new ArrayList<Integer>());
        res.get(depth).add(root.val);
        for(Node n : root.children) addToList(n, depth+1);
    }

}