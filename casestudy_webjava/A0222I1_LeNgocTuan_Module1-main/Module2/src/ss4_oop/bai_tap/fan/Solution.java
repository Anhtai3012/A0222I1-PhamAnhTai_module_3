package ss4_oop.bai_tap.fan;

public class Solution {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        Fan fan3 = new Fan();


        fan2.setStatus(false);
        fan2.setRadius(5.2);
        fan2.setSpeedFast();
        fan2.setColor("green");

        fan3.setStatus(true);
        fan3.setRadius(10.4);
        fan3.setSpeedMedium();
        fan3.setColor("yellow");

        fan1.toStringFan();
        fan2.toStringFan();
        fan3.toStringFan();
    }
}
