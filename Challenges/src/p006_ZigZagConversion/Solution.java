package p006_ZigZagConversion;

import java.util.ArrayList;

class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        ArrayList<StringBuffer> buffers = new ArrayList<StringBuffer>();
        for(int i=0;i<numRows;i++){
            buffers.add(new StringBuffer());
        }
        int way = 1;
        int bufferIndex = 0;
        for(int i=0;i<s.length();i++){
            buffers.get(bufferIndex).append(s.charAt(i));
            bufferIndex+=way;
            if(bufferIndex==(numRows-1)){
                way=-1;
            }
            if(bufferIndex==0){
                way=1;
            }
        }
        StringBuffer result = new StringBuffer();
        for(int i=0;i<numRows;i++){
            result.append(buffers.get(i));
        }
        return result.toString();
    }
}