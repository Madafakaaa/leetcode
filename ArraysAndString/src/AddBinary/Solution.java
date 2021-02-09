package AddBinary;

class Solution {
    public String addBinary(String a, String b) {
        int aIndex = a.length()-1;
        int bIndex = b.length()-1;
        StringBuilder sb = new StringBuilder();
        int extra = 0;
        while(aIndex>=0&&bIndex>=0){
            int tempA = (int)a.charAt(aIndex) - (int)('0');
            int tempB = (int)b.charAt(bIndex) - (int)('0');
            sb.append((extra+tempA+tempB)%2);
            extra = (extra+tempA+tempB)/2;
            aIndex--;
            bIndex--;
        }
        while(aIndex>=0){
            int tempA = (int)a.charAt(aIndex) - (int)('0');
            sb.append((extra+tempA)%2);
            extra = (extra+tempA)/2;
            aIndex--;
        }
        while(bIndex>=0){
            int tempB = (int)b.charAt(bIndex) - (int)('0');
            sb.append((extra+tempB)%2);
            extra = (extra+tempB)/2;
            bIndex--;
        }
        if(extra>0){
            sb.append(extra);
        }
        return sb.reverse().toString();
    }
}