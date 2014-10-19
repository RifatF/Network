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
public class Hexagon extends Applet {

    public int edgeNumber = 6;
    public int radius = 22;
    double angle = 0;
    public Polygon polygon = new Polygon(edgeNumber);
    Scanner sc = new Scanner(System.in);
    public OurSquare zona = new OurSquare(530, 440);
    boolean flag = false;
    boolean flagFor = true;
    boolean flagMove = true;


    public void paint(Graphics g) {


        setIgnoreRepaint(true);
        Point center = new Point(getWidth() / 2, getHeight() / 2);
        zona.addPointsForDraw(center);
        g.drawPolygon(zona.getXArray(), zona.getYArray(), zona.EDGE);

        int tempCentrX = (int) ((center.getX() - zona.getM() / 2) + radius / 2);
        int tempCentrY = (int) ((center.getY() - zona.getN() / 2) + (Math.sqrt(radius * radius - (radius / 2) * (radius / 2))));

        int width = (int) (Math.sqrt((radius * radius) - (radius / 2) * (radius / 2)));
        int downBorderPolygon = (int) (tempCentrY + width);
        while (tempCentrX - radius <= zona.getRightBorder()) {

            while (downBorderPolygon <= zona.getDownBorder()) {

                Polygon ss = new Polygon(edgeNumber);

                for (int i = 0; i < edgeNumber; i++) {
                    ss.getPoints().add(new Point((int) (tempCentrX + radius * Math.cos(angle * (Math.PI) / 180)),
                            (int) (tempCentrY + radius * Math.sin(angle * (Math.PI) / 180))));
                    angle = angle + 360 / edgeNumber;
                }

                if (flag) downBorderPolygon = tempCentrY + width;
                if (downBorderPolygon > zona.getDownBorder()) {
                    flagFor = false;
                }
                if (flagFor) {
                    tempCentrY = tempCentrY + 2 * width;
                } else {
                    tempCentrX = (int) (tempCentrX + 1.5 * radius);
                    flagFor = true;
                }
                g.drawPolygon(ss.getXArray(), ss.getYArray(), edgeNumber);
                flag = true;
            }

            if (flagMove) {
                downBorderPolygon = (int) ((center.getY() - zona.getN() / 2) + width);
                tempCentrY = (int) (((center.getY() - zona.getN() / 2)));
            } else {
                downBorderPolygon = (int) ((center.getY() - zona.getN() / 2) + 2 * width);
                tempCentrY = (int) (((center.getY() - zona.getN() / 2) + width));
            }
            //System.out.println(tempCentrX);
            if (flagMove) {
                flagMove = false;
            } else {
                flagMove = true;
            }
            flag = false;
        }
    }

}