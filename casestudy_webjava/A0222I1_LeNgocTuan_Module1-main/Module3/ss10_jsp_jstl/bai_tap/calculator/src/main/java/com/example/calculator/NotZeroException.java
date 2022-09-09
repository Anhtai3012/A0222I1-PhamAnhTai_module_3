package com.example.calculator;

public class NotZeroException extends Exception{
    public NotZeroException(String errorLine){
        super(errorLine);
    }

    public static double calculator(Double numb1, Double numb2, String calculator) throws NotZeroException {
        if (calculator.equals("+")) return numb1 + numb2;
        if (calculator.equals("-")) return numb1 - numb2;
        if (calculator.equals("*")) return numb1 * numb2;
        if (calculator.equals("/")) {
            if (numb2 == 0) throw new NotZeroException("Second number not in 0");
            return numb1 / numb2;
        }
        return 0;
    }
}
