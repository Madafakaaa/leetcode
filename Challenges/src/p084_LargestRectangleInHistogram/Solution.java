package p084_LargestRectangleInHistogram;

import java.util.Stack;

class Solution {

    public int largestRectangleArea(int[] heights) {
        if(heights.length==0) return 0;
        if(heights.length==1) return heights[0];
        Stack<Integer> stack = new Stack();
        int res = 0;
        stack.push(-1);
        for(int i=0;i< heights.length;i++){
            while(stack.peek()!=-1&&heights[stack.peek()]>heights[i]){
                int temp = stack.pop();
                int prev = stack.peek();
                res = Math.max(res,heights[temp]*(i-prev-1));
            }
            stack.push(i);
        }
        while(stack.peek()!=-1){
            int temp = stack.pop();
            int prev = stack.peek();
            res = Math.max(res,heights[temp]*(heights.length-prev-1));
        }
        return res;
    }

}