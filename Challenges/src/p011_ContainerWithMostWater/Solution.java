package p011_ContainerWithMostWater;

class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int lower = 0, upper=height.length-1;
        while(lower<upper){
            result  = Math.max(result, (upper-lower)*Math.min(height[lower], height[upper]));
            if(height[lower]<height[upper]){
                lower++;
            }else{
                upper--;
            }
        }
        return result;
    }
}
