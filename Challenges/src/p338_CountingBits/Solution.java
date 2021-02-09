package p338_CountingBits;

import java.util.ArrayList;

class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        if(num==0) return res;
        int max = 1, temp, tempRes, tempMax;
        ArrayList<Integer> mem = new ArrayList<>(num);
        for(int i=1;i<num+1;i++){
            if(i==max){
                res[i] = 1;
                mem.add(i);
                max*=2;
            }else{
                tempRes = 0;
                temp = i;
                for(int j=mem.size()-1;j>=0&&temp>0;j--){
                    tempMax = mem.get(j);
                    if(temp>=tempMax){
                        tempRes++;
                        temp-=tempMax;
                    }
                }
                res[i] = tempRes;
            }
        }
        return res;
    }
}
