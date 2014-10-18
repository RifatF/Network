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
        for(Point p: points) {
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
        for(Point p: points) {
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
}
