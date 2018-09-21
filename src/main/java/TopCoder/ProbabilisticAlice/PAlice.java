package TopCoder.ProbabilisticAlice;

import java.awt.*;

public class PAlice {

    private static final char TELEPORTER = 'T';
    private static final char SPACE = '.';

    public double computeExpectations(String[] grid, int pnum, int pden){

        Point pos = new Point(0, 0);
        return findProbability(grid, pnum / pden, 0, pos);
    }

    private double findProbability(String[] grid, int p, double eProb, Point pos) {

        double prob;

        if (pos.equals(new Point(grid[0].length(), grid.length))){
            return eProb;
        }

        if (grid[pos.x + 1].charAt(pos.y) == TELEPORTER){

            prob = p;
        }
        
        //findProbability(grid, p / 2, , new Point(pos.x, pos.y))

        return 0.0;
    }
}
