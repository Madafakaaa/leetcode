package p1603_DesignParkingSystem;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/3/12 9:27
 */
class ParkingSystem {

    int[] park;

    public ParkingSystem(int big, int medium, int small) {
        park = new int[3];
        park[0] = big;
        park[1] = medium;
        park[2] = small;
    }

    public boolean addCar(int carType) {
        boolean res = park[carType - 1] > 0;
        if (res) {
            park[carType - 1]--;
        }
        return res;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
