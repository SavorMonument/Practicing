package TopCoder.knishop;

public class Knishop {

    private int stX;
    private int stY;

    public Knishop(int stX, int stY) {
        this.stX = stX;
        this.stY = stY;
    }

    public Integer getShortestPath(int endX, int endY){

        int steps = 1;

        if (stX == endX && stY == endY)
            return 0;

        if (!evenTogether(stX + stY, endX + endY) && !oddTogether(stX + stY, endX + endY)) {
            steps++;
            lMoveTowards(endX, endY);
        }

        if (stX == endX && stY == endY)
            return 1;

        if (Math.pow(stX - endX, 2) != Math.pow(stY - endY, 2))
            steps++;

        return steps;

    }

    private void lMoveTowards(int endX, int endY) {

        if (Math.pow(stX - endX, 2) > Math.pow(stY - endY, 2)){

            moveTowardsX(endX, 2);
            moveTowardsY(endY, 1);

        } else{

            moveTowardsX(endX, 1);
            moveTowardsY(endY, 2);
        }
    }

    private void moveTowardsX(int endX, int amount){

        if (stX > endX) {
            stX -= amount;
        }
        else {
            stX += amount;
        }

        stX = endX;
    }

    private void moveTowardsY(int endY, int amount){

        if (stY > endY) {
            stY -= amount;
        }
        else {
            stY += amount;
        }
    }

    private static boolean evenTogether(int first, int second){

        return first % 2 == 0 && second % 2 == 0;
    }

    private static boolean oddTogether(int first, int second){

        return first % 2 != 0 && second % 2 != 0;
    }
}
