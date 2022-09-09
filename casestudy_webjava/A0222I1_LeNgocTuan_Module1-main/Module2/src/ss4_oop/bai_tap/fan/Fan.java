package ss4_oop.bai_tap.fan;

public class Fan {
    final static int SLOW = 1;
    final static int MEDIUM = 2;
    final static int FAST = 3;
    private int speed = SLOW;
    private boolean status = false;
    private double radius = 5;
    private String color = "blue";

    public Fan() {
    }

    public void toStringFan() {
        if (status) {
            System.out.printf("Fan is On. Fan is speed %d, Color %s, Radius %.2f\n", getSpeed(), getColor(), getRadius());
        } else {
            System.out.printf("Fan is Off. Fan is Color %s, Radius %.2f\n", getColor(), getRadius());
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeedFast() {
        this.speed = FAST;
    }

    public void setSpeedMedium() {
        this.speed = MEDIUM;
    }


    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
