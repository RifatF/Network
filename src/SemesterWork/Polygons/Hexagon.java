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
    int RadiusMin = 2;
    int RadiusMax = 102;
    public static int radiusBest;
    double angle = 0;
    public Polygon polygon = new Polygon(edgeNumber);
    Scanner sc = new Scanner(System.in);
    public OurSquare zona = new OurSquare(530, 440);
    boolean flag = false;
    boolean flagFor = true;
    boolean flagMove = true;
    boolean flagForExtra = true;
    int tempCentrX;
    int firstCenterX;
    int BestTempCentrX;
    int BestTempCentrY;
    int firstCentrY;
    int firstDownBorderPolygon;
    int BestDownBorderPolygon;

    public void paint(Graphics g) {

        setIgnoreRepaint(true);
        Point center = new Point(getWidth() / 2, getHeight() / 2);
        zona.addPointsForDraw(center);
        g.drawPolygon(zona.getXArray(), zona.getYArray(), zona.EDGE);
        double TempTotalArea = 0;
        double AreaOfZona = 530 * 440;
        double extra = 0;
        double extraPrev = 0;
        int BestWidth = 0;


        for (int radius = RadiusMin; radius < RadiusMax; radius++) {
            tempCentrX = ((center.getX() - zona.getM() / 2) + radius / 2);
            firstCenterX = tempCentrX;
            int tempCentrY = (int) ((center.getY() - zona.getN() / 2) + (Math.sqrt(radius * radius - (radius / 2) * (radius / 2))));
            firstCentrY = tempCentrY;
            int width = (int) (Math.sqrt((radius * radius) - (radius / 2) * (radius / 2)));
            int downBorderPolygon = (int) (tempCentrY + width);
            firstDownBorderPolygon = downBorderPolygon;
            while (tempCentrX - radius <= zona.getRightBorder()) {
                while (downBorderPolygon <= zona.getDownBorder()) {

                    Polygon ss = new Polygon(edgeNumber);

                    for (int i = 0; i < edgeNumber; i++) {
                        ss.getPoints().add(new Point((int) (tempCentrX + radius * Math.cos(angle * (Math.PI) / 180)),
                                (int) (tempCentrY + radius * Math.sin(angle * (Math.PI) / 180))));
                        angle = angle + 360 / edgeNumber;
                    }
                    TempTotalArea = TempTotalArea + ss.areaPolygon(ss);

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
                    //g.drawPolygon(ss.getXArray(), ss.getYArray(), edgeNumber);
                    flag = true;
                }

                if (flagMove) {
                    downBorderPolygon = (int) ((center.getY() - zona.getN() / 2) + width);
                    tempCentrY = (int) (((center.getY() - zona.getN() / 2)));
                } else {
                    downBorderPolygon = (int) ((center.getY() - zona.getN() / 2) + 2 * width);
                    tempCentrY = (int) (((center.getY() - zona.getN() / 2) + width));
                }
                if (flagMove) {
                    flagMove = false;
                } else {
                    flagMove = true;
                }
                flag = false;
            }
            extraPrev = TempTotalArea - AreaOfZona;
            if (flagForExtra) extra = extraPrev;
            if ((extraPrev < extra) | (flagForExtra)) {
                extra = extraPrev;
                radiusBest = radius;
                BestTempCentrX = firstCenterX;
                BestTempCentrY = firstCentrY;
                BestDownBorderPolygon = firstDownBorderPolygon;
                BestWidth = width;
            }
            TempTotalArea = 0;
            flagForExtra = false;
        }

        angle = 0;
        flag = false;
        flagFor = true;
        flagMove = true;
        flagForExtra = true;
        System.out.println(radiusBest);
        while (BestTempCentrX - radiusBest <= zona.getRightBorder()) {
            while (BestDownBorderPolygon <= zona.getDownBorder()) {
                Polygon ss = new Polygon(edgeNumber);

                for (int i = 0; i < edgeNumber; i++) {
                    ss.getPoints().add(new Point((int) (BestTempCentrX + radiusBest * Math.cos(angle * (Math.PI) / 180)),
                            (int) (BestTempCentrY + radiusBest * Math.sin(angle * (Math.PI) / 180))));
                    angle = angle + 360 / edgeNumber;
                }
                //TempTotalArea = TempTotalArea + ss.areaPolygon(ss);

                if (flag) BestDownBorderPolygon = BestTempCentrY + BestWidth;
                if (BestDownBorderPolygon > zona.getDownBorder()) {
                    flagFor = false;
                }
                if (flagFor) {
                    BestTempCentrY = BestTempCentrY + 2 * BestWidth;
                } else {
                    BestTempCentrX = (int) (BestTempCentrX + 1.5 * radiusBest);
                    flagFor = true;
                }
                g.drawPolygon(ss.getXArray(), ss.getYArray(), edgeNumber);
                flag = true;
            }

            if (flagMove) {
                BestDownBorderPolygon = (int) ((center.getY() - zona.getN() / 2) + BestWidth);
                BestTempCentrY = (int) (((center.getY() - zona.getN() / 2)));
            } else {
                BestDownBorderPolygon = (int) ((center.getY() - zona.getN() / 2) + 2 * BestWidth);
                BestTempCentrY = (int) (((center.getY() - zona.getN() / 2) + BestWidth));
            }
            if (flagMove) {
                flagMove = false;
            } else {
                flagMove = true;
            }
            flag = false;
        }

    }

}