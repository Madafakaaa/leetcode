package p035_SearchInsertPosition;

class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0) return 0;
        int l=-1,r=nums.length;
        int m;
        while(l<r-1){
            m = l+(r-l)/2;
            if(nums[m]<target){
                l=m;
            }else{
                r=m;
            }
        }
        return r;
    }
}
