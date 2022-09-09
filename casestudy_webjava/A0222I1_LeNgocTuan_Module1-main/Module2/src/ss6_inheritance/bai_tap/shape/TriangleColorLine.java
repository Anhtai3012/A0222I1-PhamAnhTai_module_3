package ss6_inheritance.bai_tap.shape;

public class TriangleColorLine extends Triangle {
    private String color1;
    private String color2;
    private String color3;

    public TriangleColorLine(double line1, double line2, double line3, String color1, String color2, String color3) {
        super(line1, line2, line3);
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
    }

    public TriangleColorLine(double line1, double line2, double line3) {
        super(line1, line2, line3);
    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getColor3() {
        return color3;
    }

    public void setColor3(String color3) {
        this.color3 = color3;
    }

    public String toString() {
        return String.format("Triangle with 3 line: %.3f %s, %.3f %s, %.3f %s get area %.3f, perimeter %.3f\n", super.line1, getColor1(), super.line2, getColor2(), super.line3, getColor3(),getArea(),getPerimeter());
    }
}
