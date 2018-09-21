package Algorithms;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Dice {

    private static final int SIDES = 6;

    public static void main(String[] args) {

        int keyboard = 1;

        while (keyboard != 0) {

            keyboard = StdIn.readInt();
            double[] randomDices = getRandomDiceNumbers(2, keyboard);
            double[] meanDiceValues = getMeanDiceValues();

            for (int k = 2; k <= 2 * SIDES; k++) {
                StdOut.print(String.format("Number %d times: %d, probability %.5f", k, (int)randomDices[k], randomDices[k] / keyboard));
                StdOut.print(String.format("    meanP:%.5f", meanDiceValues[k]));
                StdOut.println();
            }
        }

    }

    private static double[] getMeanDiceValues() {

        double[] values = new double[2 * SIDES + 1];

        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                values[i+j] += 1.0;

        for (int k = 2; k <= 2*SIDES; k++)
            values[k] /= 36.0;

        return values;
    }

    private static double[] getRandomDiceNumbers(int numberOfDices, int numberAmount){

        double[] dist = new double[numberOfDices * SIDES + 1];

        for (int i = 0; i < numberAmount; i++) {

            int sum = 0;
            for(int j = 0; j < numberOfDices; j++)
                sum += (int)(Math.random() * 6) + 1;

            dist[sum] += 1.0;
        }

        return dist;
    }
}
