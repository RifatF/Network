import java.applet.Applet;
import java.awt.*;

/**
 * Created by Rigen on 18.10.14.
 */
public class Paint extends Applet {

    public int edgeNumber = 9;
    public int radius = 100;
    double angle = 270;
    public Polygon polygon = new Polygon(edgeNumber);
    private Point center;

    public void paint(Graphics g) {
        setSize(new Dimension(500, 500));
        center = new Point(getWidth()/2, getHeight()/2);
        //g.drawOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
        for (int i = 0; i < edgeNumber; i++) {
            polygon.getPoints().add(new Point((int)(center.getX() + radius * Math.cos(angle * (Math.PI)/180)),
                (int)(center.getY() + radius * Math.sin(angle * (Math.PI)/180))));
            angle = angle + 360/edgeNumber;
        }
        g.drawPolygon(polygon.getXArray(), polygon.getYArray(), polygon.getEdgeNumber());


    }
}
