package Algorithms;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

public class DottedCircle {

    public static void main(String[] args) {

        Point2D[] points = calculateCircleDots(0.5, 0.5, 0.45, 20);
        drawPoints(points);
        conntectPoints(points, 0.5);
    }

    private static void drawDottedCircle(double x, double y, double r, double amount) {
        double i, angle, x1, y1;
        double increment = 360 / amount;

        for(i = 0; i < 360; i += increment)
        {
            angle = i;
            x1 = r * Math.cos(angle * Math.PI / 180) + x;
            y1 = r * Math.sin(angle * Math.PI / 180) + y;
            StdDraw.filledCircle(x1, y1, 0.05);
        }
    }

    private static Point2D[] calculateCircleDots(double x, double y, double r, int pointAmount){

        Point2D[] points = new Point2D[pointAmount];
        double angle, x1, y1;
        double increment = 360 / pointAmount;

        for(double i = 0; i < 360; i += increment) {

            angle = i;
            x1 = r * Math.cos(angle * Math.PI / 180) + x;
            y1 = r * Math.sin(angle * Math.PI / 180) + y;
            points[(int)(i / increment)] = new Point2D(x1, y1);
        }

        return points;
    }

    private static void drawPoints(Point2D[] points){

        for (Point2D p: points){

            StdDraw.filledCircle(p.x(), p.y(), 0.05);
        }
    }

    private static void conntectPoints(Point2D[] points, double probability){

        for(int i = 1; i < points.length; i++){

            connectPoint(points[i - 1].x(), points[i - 1].y(), points[i].x(), points[i].y(), probability);
        }
    }

    private static void connectPoint(double x1, double y1, double x2, double y2, double probablility){

        double rng = Math.random();
        if (rng < probablility){

            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.line(x1, y1, x2, y2);
            StdDraw.setPenColor(StdDraw.BLACK);
        }
    }



}
