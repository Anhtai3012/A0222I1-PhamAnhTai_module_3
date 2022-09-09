package ss6_inheritance.bai_tap.point;

public class Point2D {
    protected double x = 1d;
    protected double y = 2d;
    public Point2D (){

    }
    public Point2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public void setXY(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double[] getXY(){
        return new double[]{x,y};
    }
    public String toString(){
        return String.format("Point2D: {x %f, y: %f}\n",getX(),getY());
    }
}
