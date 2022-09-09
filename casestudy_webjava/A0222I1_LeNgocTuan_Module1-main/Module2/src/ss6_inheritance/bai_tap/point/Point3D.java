package ss6_inheritance.bai_tap.point;

public class Point3D extends Point2D {
    private double z = 1d;

    public Point3D() {

    }

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setXYZ(double x, double y, double z) {
        setXY(x, y);
        this.z = z;
    }

    public double[] getXYZ() {
        return new double[]{x, y, z};
    }

    public String toString() {
        return String.format("Point3D: {x %f, y: %f, z: %f}\n", getX(), getY(), getZ());
    }
}
