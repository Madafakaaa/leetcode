package ValidMountainArray;

class Solution {

    public boolean validMountainArray(int[] arr) {
        if(arr.length<3){
            return false;
        }
        if(arr[0]>=arr[1]) return false;
        boolean isUp = true;
        for(int i=1;i<arr.length-1;i++){
            if(isUp){
                if(arr[i]==arr[i+1]){
                    return false;
                }else if(arr[i]>arr[i+1]){
                    isUp = false;
                }
            }else{
                if(arr[i]==arr[i+1]){
                    return false;
                }else if(arr[i]<arr[i+1]){
                    return false;
                }
            }
        }
        if(isUp) return false;
        return true;
    }

}