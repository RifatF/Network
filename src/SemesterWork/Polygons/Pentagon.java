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
public class Pentagon extends Applet {

    public final int EDGE = 5;
    public int radius = 25;
    double angle = 90;
    public Polygon polygon = new Polygon(EDGE);
    Scanner sc = new Scanner(System.in);
    public OurSquare zona = new OurSquare(300, 300);
    public double edgeSize;
    public double smallHeight;

    {
        edgeSize = radius * 1.175;
        smallHeight = 0.688 * edgeSize;
    }

    public void paint(Graphics g) {
        setIgnoreRepaint(true);
        Point center = new Point(getWidth() / 2, getHeight() / 2);

        zona.addPointsForDraw(center);
        g.drawPolygon(zona.getXArray(), zona.getYArray(), zona.EDGE);

        Point tempCenter = new Point(center.getX(), center.getY());
        tempCenter.setX(zona.getPoints().get(1).getX() + (int) edgeSize / 2);
        tempCenter.setY(zona.getPoints().get(1).getY() + (int) smallHeight);

        int somethingHeight = (int) (edgeSize * Math.sin(360 / EDGE * (Math.PI) / 180));

        Polygon pentagon = new Polygon(EDGE);
        for (int i = 0; i < EDGE; i++) {
            pentagon.getPoints().add(new Point((int) (tempCenter.getX() + radius * Math.cos(angle * (Math.PI) / 180)),
                    (int) (tempCenter.getY() + radius * Math.sin(angle * (Math.PI) / 180))));
            angle = angle + 360 / EDGE;
        }

        g.drawPolygon(pentagon.getXArray(), pentagon.getYArray(), EDGE);
        tempCenter.setY(tempCenter.getY() + 2 * radius + 2 * somethingHeight);

        while ((zona.getDownBorder() - tempCenter.getY()) > -radius) {
            angle = -90;
            pentagon = new Polygon(EDGE);
            for (int i = 0; i < EDGE; i++) {
                pentagon.getPoints().add(new Point((int) (tempCenter.getX() + radius * Math.cos(angle * (Math.PI) / 180)),
                        (int) (tempCenter.getY() + radius * Math.sin(angle * (Math.PI) / 180))));
                angle = angle + 360 / EDGE;
            }
            angle = 90;

            pentagon = new Polygon(EDGE);
            for (int i = 0; i < EDGE; i++) {
                pentagon.getPoints().add(new Point((int) (tempCenter.getX() + radius * Math.cos(angle * (Math.PI) / 180)),
                        (int) (tempCenter.getY() + radius * Math.sin(angle * (Math.PI) / 180))));
                angle = angle + 360 / EDGE;
            }
            g.drawPolygon(pentagon.getXArray(), pentagon.getYArray(), EDGE);
            tempCenter.setY(tempCenter.getY() + 2 * radius + 2 * somethingHeight);
        }


//        int width = (int)(Math.sqrt((radius * radius) - (radius / 2) * (radius / 2)));
//
//        while (tempCenter.getY() < zona.getDownBorder()) {
//            tempCenter.setY(tempCenter.getY() + 2*width);
//            Polygon ss = new Polygon(EDGE);
//
//            for (int i = 0; i < EDGE; i++) {
//                ss.getPoints().add(new Point((int) (tempCenter.getX() + radius * Math.cos(angle * (Math.PI) / 180)),
//                        (int) (tempCenter.getY() + radius * Math.sin(angle * (Math.PI) / 180))));
//                angle = angle + 360 / EDGE;
//            }
//            g.drawPolygon(ss.getXArray(),ss.getYArray(), EDGE);
//        }
    }
}
