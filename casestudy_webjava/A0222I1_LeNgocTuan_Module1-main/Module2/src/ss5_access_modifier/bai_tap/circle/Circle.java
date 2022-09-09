package ss5_access_modifier.bai_tap.circle;

public class Circle {
    private float radius = 1f;
    private String color = "red";
    final float PI = 3.1415f;
    public Circle(){

    };
    public Circle(float radius, String color){
        this.radius = radius;
        this.color = color;
    }
    private float getRadius(){
        return radius;
    }
    private float getArea(){
        return (float) Math.pow(radius, 2) * PI;
    }
    public void getInfo(){
        System.out.printf("Circle has radius %.3f color %s get area %.3f\n",getRadius(),color,getArea());
    }
}
