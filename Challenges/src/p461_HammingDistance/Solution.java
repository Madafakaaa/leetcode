package p461_HammingDistance;

class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        while (x > 0 || y > 0) {
            int tempX = x & 1;
            int tempY = y & 1;
            res += tempX ^ tempY;
            x = x >> 1;
            y = y >> 1;
        }
        return res;
    }
}