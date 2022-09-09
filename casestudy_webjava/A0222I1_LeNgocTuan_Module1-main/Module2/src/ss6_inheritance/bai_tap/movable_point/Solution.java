package ss6_inheritance.bai_tap.movable_point;

public class Solution {
    public static void main(String[] args) {
        Point point = new Point(11f, 12f);
        MovablePoint movablePoint = new MovablePoint(12f, 13f, 11f, 2f);
        System.out.println(point.toString());
        System.out.println(movablePoint.toString());
    }
}
