package Algorithms;

import java.util.ArrayList;
import java.util.Stack;

public class Dijkstra {

    public static double solve(String equation){

        Stack<Double> operands = new Stack<>();
        Stack<String> operators = new Stack<>();

        String[] tokens = equation.split(" ");

        for (String t: tokens) {

            if (isOperand(t)){
                operands.push(Double.parseDouble(t));
            } else
                if (isOperator(t))
                    operators.push(t);
                else
                    if (t.equals(")"))
                        operands.push(doOperation(operands.pop(), operators.pop(), operands.pop()));
        }

        return doOperation(operands.pop(), operators.pop(), operands.pop());
    }

    private static boolean isOperand(String o) {
        assert (null != o): "Null string";

        try {
            Double.parseDouble(o);
        } catch (NumberFormatException e){

            return false;
        }
        return true;
    }

    private static boolean isOperator(String o) {
        assert (null != o): "Null string";

        return o.equals("-") || o.equals("+") || o.equals("*") || o.equals("/");
    }

    private static double doOperation(double x, String operator, double y) {
        assert (null != operator): "Null string";

        switch (operator){
            case "-":
                return x - y;
            case "+":
                return x + y;
            case "*":
                return x * y;
            case "/":
                return y / x;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
