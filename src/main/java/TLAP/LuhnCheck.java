package TLAP;

import edu.princeton.cs.algs4.StdIn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LuhnCheck {

    private static Scanner in = new Scanner(System.in).useDelimiter(Pattern.compile(""));

    public static boolean isDigit(char c){

        return c >= '0' && c <='9';
    }

    public static int calculateDoubleDigitSum(int n){

        return calculateDigitSum(n * 2);
    }

    public static int calculateDigitSum(int n){
        int sum = 0;

        while (n != 0){

            sum = n % 10;
            n = n / 10;
        }

        return sum;
    }

    public static char readCharStd(){

        return in.next().charAt(0);
    }

    public static int charToDigit(char c){
        assert isDigit(c): "Not a digit";

        return (int) c - '0';
    }

    private static boolean isEven(int counter) {

        return counter % 2 == 0;
    }

    public static void main(String[] args) {

        char inputChar;
        int counter = 0;
        int oddSum = 0;
        int evenSum = 0;


        while ((inputChar = readCharStd()) != 10){

            if (isEven(counter)){
                evenSum += calculateDoubleDigitSum(charToDigit(inputChar));
                oddSum += charToDigit(inputChar);
            } else {
                evenSum += charToDigit(inputChar);
                oddSum += calculateDoubleDigitSum(charToDigit(inputChar));
            }

            counter++;
        }

        if (isEven(counter))
            System.out.println("Sum is bla blabla: " + evenSum);
        else
            System.out.println("Sum is bla blabla: " + oddSum);
    }
}
