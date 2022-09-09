package ss15_debugger_error.bai_tap;

import java.util.Scanner;

public class Triangle {
    static class IllegalTriangleException extends Exception {
        String errorLine;

        public IllegalTriangleException(String errorLine) {
            this.errorLine = errorLine;
        }

        public String toString() {
            return errorLine;
        }
    }

    public static void checkTriangle(int s1, int s2, int s3) throws IllegalTriangleException {
        if (s1 + s2 < s3 || s1 + s3 < s2 || s2 + s3 < s1) {
            throw new IllegalTriangleException("Not Triangle sums of two slide must bigger other slide");
        }
        if (s1 < 0 || s2 < 0 || s3 < 0) {
            throw new IllegalTriangleException("Not Triangle. Slide must > 0");
        }
        throw new IllegalTriangleException("Right Triangle");
    }

    public static void main(String[] args) throws IllegalTriangleException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Slide 1: ");
        int slide1 = Integer.parseInt(scanner.nextLine());
        System.out.print("Slide 2: ");
        int slide2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Slide 3: ");
        int slide3 = Integer.parseInt(scanner.nextLine());
        checkTriangle(slide1, slide2, slide3);
    }
}
