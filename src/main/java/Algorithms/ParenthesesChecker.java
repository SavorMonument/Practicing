package Algorithms;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

public class ParenthesesChecker {

    public static void main(String[] args) {

        Stack<Character> sequence = new Stack<>();
        boolean finished = false;

        while(!finished){
            char current;

            if (StdIn.hasNextChar() && (current = StdIn.readChar()) != '\n') {
                StdIn.readLine();

                finished = true;

                if (Parentheses.isParentheses(current)) {

                    if (sequence.isEmpty()) {

                        if (Parentheses.isOpenParentheses(current)) {
                            sequence.push(current);
                            finished = false;
                        }
                    }
                    else {

                        if (Parentheses.canFollow(sequence.peek(), current)) {

                            if (Parentheses.isPair(sequence.peek(), current))
                                sequence.push(current);
                            else
                                sequence.pop();

                            finished = false;

                        }
                    }
                }
            }
        }

        System.out.println("You're done for sir");

    }

    private static class Parentheses{

        static boolean isOpenParentheses(char p){

            return p == '{' || p == '[' || p == '(';
        }

        static boolean isParentheses(char p){

            return p == '[' || p == ']' || p == '(' || p == ')' || p == '{' || p == '}';
        }

        static boolean isPair(char p1, char p2){

            return p1 == '[' && p2 == ']' || p1 == '(' && p2 == ')' || p1 == '{' && p2 == '}';
        }

        static boolean canFollow(char p1, char p2){

            return p1 == '{' && p2 == '[' || p1 == '{' && p2 == '(' || p1 == '[' && p2 == '(' ||
                    p1 == '(' && p2 == '(' || isPair(p1, p2);
        }


    }
}
