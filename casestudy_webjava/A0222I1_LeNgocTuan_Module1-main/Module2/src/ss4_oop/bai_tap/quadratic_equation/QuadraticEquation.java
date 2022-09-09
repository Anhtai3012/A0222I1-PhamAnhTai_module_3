package ss4_oop.bai_tap.quadratic_equation;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    private double delta;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.delta = calculatorDelta();
    }

    private double calculatorDelta() {
        return (Math.pow(b, 2)) - (4 * a * c);
    }

    private double calculatorX1() {
        return (-b + (Math.sqrt(delta))) / (2 * a);
    }

    private double calculatorX2() {
        return (-b - (Math.sqrt(delta))) / (2 * a);
    }

    private double calculatorIdenticalX() {
        return (-b) / (2 * a);
    }

    public void displayResult() {
        if (delta < 0) {
            System.out.println("Quadratic Equation isn't answer because delta smaller 0");
        } else if (delta == 0) {
            System.out.printf("Quadratic Equation is identical x: %f", calculatorIdenticalX());
        } else {
            System.out.printf("Quadratic Equation have 2 value. x1 = %.2f, x2 = %.2f", calculatorX1(), calculatorX2());
        }
    }


}
