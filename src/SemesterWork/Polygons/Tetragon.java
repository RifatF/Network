package SemesterWork.Polygons;

import SemesterWork.OurSquare;
import SemesterWork.Point;
import SemesterWork.Polygon;

import java.applet.Applet;
import java.awt.*;
import java.util.Scanner;

/**
 * Created by Rigen on 18.10.14.
 */
public class Tetragon extends Applet {

    public final int EDGE = 4;
    public int radius = 17;
    double angle = 45;
    public Polygon polygon = new Polygon(EDGE);
    Scanner sc = new Scanner(System.in);
    public OurSquare zona = new OurSquare(500, 500);


    public void paint(Graphics g) {
//        setSize(new Dimension(700, 700));
        setIgnoreRepaint(true);
        Point center = new Point(getWidth() / 2, getHeight() / 2);
        zona.addPointsForDraw(center);
        g.drawPolygon(zona.getXArray(), zona.getYArray(), zona.EDGE);
        Polygon ss = new Polygon(EDGE);

        int tempCentrX = zona.getPoints().get(1).getX() + (int) Math.sqrt((radius * radius) / 2);
        int tempCentrY = zona.getPoints().get(1).getY() + (int) Math.sqrt((radius * radius) / 2);

        while (tempCentrY - Math.sqrt(2 * radius * radius) + (int) Math.sqrt((radius * radius) / 2) < zona.getDownBorder()) {
            //go down
            ss = new Polygon(EDGE);
            ss = createArrayOfXandY(tempCentrX, tempCentrY, ss);
            g.drawPolygon(ss.getXArray(), ss.getYArray(), ss.getEdgeNumber());
            int myTempX = tempCentrX;
            while (tempCentrX + (int) Math.sqrt((radius * radius) / 2) < zona.getRightBorder()) {
                //go Right
                tempCentrX += Math.sqrt(2 * radius * radius);
                ss = new Polygon(EDGE);
                ss = createArrayOfXandY(tempCentrX, tempCentrY, ss);
                g.drawPolygon(ss.getXArray(), ss.getYArray(), ss.getEdgeNumber());
            }
            tempCentrX = myTempX;
            tempCentrY += Math.sqrt(2 * radius * radius);
        }
    }

    public Polygon createArrayOfXandY(int tempCentrX, int tempCentrY, Polygon qu) {
        for (int i = 0; i < EDGE; i++) {
            qu.getPoints().add(new Point((int) (tempCentrX + radius * Math.cos(angle * (Math.PI) / 180)),
                    (int) (tempCentrY + radius * Math.sin(angle * (Math.PI) / 180))));
            angle = angle + 360 / EDGE;
        }
        return qu;
    }

}

