package p199_BinaryTreeRightSideView;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/4 9:27
 */
class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(Objects.isNull(root)){return res;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode tempRight = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                tempRight = queue.poll();
                if(Objects.nonNull(tempRight.left)){
                    queue.add(tempRight.left);
                }
                if(Objects.nonNull(tempRight.right)){
                    queue.add(tempRight.right);
                }
            }
            res.add(tempRight.val);
        }
        return res;
    }

}