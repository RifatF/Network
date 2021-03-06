package SemesterWork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EduardP on 18.10.14.
 */
public class OurSquare extends Polygon {

    int rightBorder = 0;
    int leftBorder = 0;
    int upBorder = 0;
    int downBorder = 0;

    private List<Point> points = new ArrayList<Point>();
    private int m;
    private int n;
    public final int EDGE = 4;

    public OurSquare(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int[] getXArray() {
        int[] a = new int[EDGE];
        int i = 0;
        for (Point p : points) {
            a[i] = p.getX();
            i++;
            if (i == EDGE)
                break;
        }
        return a;
    }

    public int[] getYArray() {
        int[] a = new int[EDGE];
        int i = 0;
        for (Point p : points) {
            a[i] = p.getY();
            i++;
            if (i == EDGE)
                break;
        }
        return a;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void addPointsForDraw(Point center) {
        points.add(new Point(center.getX() + (m / 2) * -1, center.getY() + (n / 2) * 1));
        points.add(new Point(center.getX() + (m / 2) * -1, center.getY() + (n / 2) * -1));
        points.add(new Point(center.getX() + (m / 2) * 1, center.getY() + (n / 2) * -1));
        points.add(new Point(center.getX() + (m / 2) * 1, center.getY() + (n / 2) * 1));

        rightBorder = center.getX() + getM() / 2;
        leftBorder = center.getX() - getM() / 2;
        upBorder = center.getY() - getN() / 2;
        downBorder = center.getY() + getN() / 2;
    }

    public int getRightBorder() {
        return rightBorder;
    }

    public int getLeftBorder() {
        return leftBorder;
    }

    public int getUpBorder() {
        return upBorder;
    }

    public int getDownBorder() {
        return downBorder;
    }

}
