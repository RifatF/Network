import java.util.ArrayList;
import java.util.List;

/**
 * Created by EduardP on 18.10.14.
 */
public class ourSquare extends Polygon{
    private List<Point> points = new ArrayList<Point>();
    int m = 0;
    int n = 0;
    int edgeNumber = 4;

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

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public int getEdgeNumber() {
        return edgeNumber;
    }
}
