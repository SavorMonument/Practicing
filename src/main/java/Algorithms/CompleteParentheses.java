package Algorithms;

public class CompleteParentheses {

    public static void main(String[] args) {
        assert (args.length > 0): "No argument";

        StringBuilder equation = new StringBuilder("( " + args[0]);
        int nrCounter = 0;
        int parCounter = 0;

        for(int i = equation.length() - 1; i >= 0; i--){

            if (equation.charAt(i) == ')')
                parCounter += 1;

            if (equation.charAt(i) >= '0' &&  equation.charAt(i) <= '9')
                nrCounter += 1;

            if (nrCounter == 2){
                if (parCounter > 1) {

                    equation = new StringBuilder(equation.substring(0, i) + '(' + ' ' + equation.substring(i));
                    parCounter -= 1;
                }
                nrCounter = 0;
            }
        }

        System.out.println(equation.toString());

    }
}
