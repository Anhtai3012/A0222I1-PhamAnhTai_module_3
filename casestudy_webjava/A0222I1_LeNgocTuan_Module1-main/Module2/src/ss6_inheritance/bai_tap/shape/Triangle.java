package ss6_inheritance.bai_tap.shape;

public class Triangle {
    protected double line1 = 1d;
    protected double line2 = 1d;
    protected double line3 = 1d;

    public Triangle() {
    }

    public Triangle(double line1, double line2, double line3) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
    }

    public double getLine1() {
        return line1;
    }

    public void setLine1(double line1) {
        this.line1 = line1;
    }

    public double getLine2() {
        return line2;
    }

    public void setLine2(double line2) {
        this.line2 = line2;
    }

    public double getLine3() {
        return line3;
    }

    public void setLine3(double line3) {
        this.line3 = line3;
    }

    public double getPerimeter() {
        return getLine1() + getLine2() + getLine3();
    }

    public double getArea() {
        return (Math.sqrt(3) / 4) * Math.pow(getLine1(), 2);
    }
    public String toString(){
        return String.format("Triangle with 3 line: %.3f, %.3f, %.3f get area %.3f, perimeter %.3f\n",getLine1(),getLine2(),getLine3(),getArea(),getPerimeter());
    }
}
