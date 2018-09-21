package TopCoder.HillClimber;

public class HillClimber {

    public int climb(int[] heights){

        int risingSection = 0;
        int maxSec = 0;

        for (int i = 0; i < heights.length - 1; i++) {

            if (heights[i] < heights[i + 1])
                risingSection++;
            else{
                if (risingSection > maxSec)
                    maxSec = risingSection;
                risingSection = 0;
            }
        }

        if (risingSection > maxSec)
            maxSec = risingSection;

        return maxSec;
    }
}
