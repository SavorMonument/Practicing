package TopCoder.IntervalIntersections;

public class IntervalIntersections {

    public int minLength(int x1, int y1, int x2, int y2) {

        Interval firstInterval;
        Interval secondInterval;

        if (x2 < x1) {
            firstInterval = new Interval(x2, y2);
            secondInterval = new Interval(x1, y1);
        } else{
            firstInterval = new Interval(x1, y1);
            secondInterval = new Interval(x2, y2);
        }


        if (areOverlapping(firstInterval, secondInterval)){
            return 0;
        } else
            return getDistance(firstInterval.y, secondInterval.x);

    }

    private int getDistance(int x, int y) {

        if (y < x){
            int aux = x;
            x = y;
            y = aux;
        }

        return y - x;
    }

    private boolean areOverlapping(Interval inter1, Interval inter2){

        return (inter1.y >= inter2.x);
    }

    private class Interval{

        private int x;
        private int y;

        private Interval(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
