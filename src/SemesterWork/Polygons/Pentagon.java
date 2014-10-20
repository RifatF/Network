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
    public OurSquare zona = new OurSquare(500, 450);
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

        Point firstTempCenter = new Point(zona.getPoints().get(1).getX() + (int) edgeSize / 2, zona.getPoints().get(1).getY() + (int) smallHeight);
        Point tempCenter = new Point(firstTempCenter.getX(), firstTempCenter.getY());

        int somethingHeight = (int) ((1.539 * edgeSize) - radius);
        double diagonal = (1.618 * edgeSize);

        Polygon pentagon = null;


        boolean flag = false;

        while ((firstTempCenter.getX() - zona.getRightBorder()) < 0) {
            tempCenter = new Point(firstTempCenter.getX(), firstTempCenter.getY());

            if (!flag) {
//                firstTempCenter.setY((zona.getPoints().get(1).getY() + (int) smallHeight));
                tempCenter = new Point(firstTempCenter.getX(), firstTempCenter.getY());
                pentagon = new Polygon(EDGE);
                for (int i = 0; i < EDGE; i++) {
                    pentagon.getPoints().add(new Point((int) (tempCenter.getX() + radius * Math.cos(angle * (Math.PI) / 180)),
                            (int) (tempCenter.getY() + radius * Math.sin(angle * (Math.PI) / 180))));
                    angle = angle + 360 / EDGE;
                }

                g.drawPolygon(pentagon.getXArray(), pentagon.getYArray(), EDGE);
                tempCenter.setY((int) (tempCenter.getY() + 2 * radius + 2 * somethingHeight + 2 * (radius - edgeSize * Math.sin(36 * Math.PI / 180))));
            }

            while ((zona.getDownBorder() - tempCenter.getY()) > -radius) {

                angle = -90;
                pentagon = new Polygon(EDGE);
                for (int i = 0; i < EDGE; i++) {
                    pentagon.getPoints().add(new Point((int) (tempCenter.getX() + radius * Math.cos(angle * (Math.PI) / 180)),
                            (int) (tempCenter.getY() + radius * Math.sin(angle * (Math.PI) / 180))));
                    angle = angle + 360 / EDGE;
                }
                g.drawPolygon(pentagon.getXArray(), pentagon.getYArray(), EDGE);
                tempCenter.setY(tempCenter.getY() + (int) smallHeight * 2);
                angle = 90;

                if ((zona.getDownBorder() - tempCenter.getY()) > -radius) {
                    pentagon = new Polygon(EDGE);
                    for (int i = 0; i < EDGE; i++) {
                        pentagon.getPoints().add(new Point((int) (tempCenter.getX() + radius * Math.cos(angle * (Math.PI) / 180)),
                                (int) (tempCenter.getY() + radius * Math.sin(angle * (Math.PI) / 180))));
                        angle = angle + 360 / EDGE;
                    }
                    g.drawPolygon(pentagon.getXArray(), pentagon.getYArray(), EDGE);
                    tempCenter.setY((int) (tempCenter.getY() + 2 * radius + 2 * somethingHeight + 2 * (radius - edgeSize * Math.sin(36 * Math.PI / 180))));
                }

            }
            flag = !flag;
            if (flag) {
                firstTempCenter.setX(firstTempCenter.getX() + (int) diagonal / 2);
                firstTempCenter.setY((int) (firstTempCenter.getY() + radius * 2 - edgeSize * Math.sin(36 * Math.PI / 180)));
            } else {
                firstTempCenter.setX(firstTempCenter.getX() + (int) diagonal / 2);
//                firstTempCenter.setY((int)(firstTempCenter.getY() - radius * 2 + edgeSize * Math.sin(36 * Math.PI / 180)));
                firstTempCenter.setY((zona.getPoints().get(1).getY() + (int) smallHeight));
            }
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
