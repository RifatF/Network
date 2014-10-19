package SemesterWork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rigen on 18.10.14.
 */
public class Polygon {
    private List<Point> points = new ArrayList<Point>();
    private int edgeNumber;

    public int[] getXArray() {
        int[] a = new int[edgeNumber];
        int i = 0;
        for (Point p : points) {
            a[i] = p.getX();
            i++;
            if (i == edgeNumber)
                break;
        }
        return a;
    }

    public int[] getYArray() {
        int[] a = new int[edgeNumber];
        int i = 0;
        for (Point p : points) {
            a[i] = p.getY();
            i++;
            if (i == edgeNumber)
                break;
        }
        return a;
    }

    public Polygon() {
    }

    public Polygon(int edgeNumber) {
        this.edgeNumber = edgeNumber;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public int getEdgeNumber() {
        return edgeNumber;
    }

    public void setEdgeNumber(int edgeNumber) {
        this.edgeNumber = edgeNumber;
    }

    public double areaPolygon(Polygon polygon) {
        double x1 = polygon.getPoints().get(0).getX();
        System.out.println("x1=" + x1);
        double x2 = polygon.getPoints().get(1).getX();
        System.out.println("x2=" + x2);
        double y1 = polygon.getPoints().get(0).getY();
        System.out.println("y1=" + y1);
        double y2 = polygon.getPoints().get(1).getY();
        System.out.println("y2=" + y2);
        double a = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        System.out.println("a=" + a);
        double S = ((edgeNumber * a * a) / (4 * (Math.tan(Math.PI / edgeNumber))));
        System.out.println("S=" + S);
        return S;
    }

}
