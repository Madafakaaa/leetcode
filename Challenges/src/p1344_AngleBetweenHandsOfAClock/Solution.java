package p1344_AngleBetweenHandsOfAClock;

/**
 * @description:
 * @author: ziyi3.zhang
 * @CreateDate: 2021/8/24 11:32
 */
class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteAngle = minutes * 60;
        double hourAngle = (hour % 12) * 30 + (double) minutes / 2D;
        double angle = (hourAngle - minuteAngle + 360) % 360;
        return Math.min(angle, 360 - angle);
    }
}
