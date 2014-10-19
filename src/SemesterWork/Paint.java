package SemesterWork;

import java.applet.Applet;
import java.awt.*;
import java.util.Scanner;

/**
 * Created by Rigen on 18.10.14.
 */
public class Paint extends Applet {

    public int edgeNumber = 7;
    public int radius = 50;
    double angle = -90;
    public SemesterWork.Polygon polygon = new SemesterWork.Polygon(edgeNumber);
    Scanner sc = new Scanner(System.in);


    public void paint(Graphics g) {
        setIgnoreRepaint(true);
        SemesterWork.Point center = new SemesterWork.Point(getWidth() / 2, getHeight() / 2);
//        g.drawOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
        for (int i = 0; i < edgeNumber; i++) {
            polygon.getPoints().add(new SemesterWork.Point((int) (center.getX() + radius * Math.cos(angle * (Math.PI) / 180)),
                    (int) (center.getY() + radius * Math.sin(angle * (Math.PI) / 180))));
            angle = angle + 360 / edgeNumber;
        }
        g.drawPolygon(polygon.getXArray(), polygon.getYArray(), polygon.getEdgeNumber());
    }
}
