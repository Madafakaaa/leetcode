package p034_FindFirstAndLastPositionOfElementInSortedArray;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if(nums.length==0) return res;
        int l1 = -1, r1 = nums.length;
        while(l1+1<r1){
            int m1 = l1+(r1-l1)/2;
            if(nums[m1]<target){
                l1 = m1;
            }else{
                r1 = m1;
            }
        }
        if(r1!=nums.length&&nums[r1]==target) res[0] = r1;
        int l2 = -1, r2 = nums.length;
        while(l2+1<r2){
            int m2 = l2+(r2-l2)/2;
            if(nums[m2]<=target){
                l2 = m2;
            }else{
                r2 = m2;
            }
        }
        if(l2!=-1&&nums[l2]==target) res[1] = l2;
        return res;
    }
}