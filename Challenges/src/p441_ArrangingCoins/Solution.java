package p441_ArrangingCoins;

class Solution {
    public int arrangeCoins(int n) {
        int res = 0;
        int row = 1;
        while (n >= row) {
            n -= row;
            row++;
            res++;
        }
        return res;
    }
}