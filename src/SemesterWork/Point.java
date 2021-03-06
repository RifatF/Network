package SemesterWork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rigen on 18.10.14.
 */
public class Point {

    private List<Point> points = new ArrayList<Point>();
    private int edgeNumber;

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
