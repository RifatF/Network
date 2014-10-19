package SemesterWork.Polygons;

import java.applet.Applet;
import java.awt.*;
import java.util.Scanner;

import SemesterWork.*;
import SemesterWork.Point;
import SemesterWork.Polygon;


/**
 * Created by Rigen on 18.10.14.
 */
public class Trigon extends Applet {

    public final int edgeNumber = 3;
    public int radius = 15;
    double angle = 0;
    public Polygon polygon = new Polygon(edgeNumber);
    public OurSquare zona = new OurSquare();
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();



    public void paint(Graphics g) {
//        setSize(new Dimension(1366, 768));
        setIgnoreRepaint(true);
        Point center = new Point(getWidth() / 2, getHeight() / 2);
//      g.drawOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
        for (int i = 0; i < edgeNumber; i++) {
            polygon.getPoints().add(new Point((int) (center.getX() + radius * Math.cos(angle * (Math.PI) / 180)),
                    (int) (center.getY() + radius * Math.sin(angle * (Math.PI) / 180))));
            angle = angle + 360 / edgeNumber;
        }
//        g.drawPolygon(polygon.getXArray(), polygon.getYArray(), polygon.getEdgeNumber());


        zona.setM(m);
        zona.setN(n);
        zona.addPointsForDraw(center);
        g.drawPolygon(zona.getXArray(), zona.getYArray(), zona.EDGE);
        //polygon.areaPolygon(polygon);

//        System.out.println("Right border " + zona.getRightBorder());
//        System.out.println("Left border " + zona.getLeftBorder());
//        System.out.println("Up border " + zona.getUpBorder());
//        System.out.println("Down border " + zona.getDownBorder());

        int x1 = polygon.getPoints().get(0).getX();
        int x2 = polygon.getPoints().get(1).getX();
        int y1 = polygon.getPoints().get(0).getY();
        int y2 = polygon.getPoints().get(1).getY();
        int a = (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        
//        int TempCenrX = center.getX();
//        while (TempCenrX < zona.getUpBorder()) {
//            TempCenrX = TempCenrX +
//        }

        angle = 31;
        int width = (int)(radius + (Math.sqrt((radius * radius) - (a/2)*(a/2))));
        int height = (int)(Math.sqrt((radius * radius) - (radius / 2) * (radius / 2)));
        int tempCentrX = center.getX()-zona.getM()/2;
        int tempCentrY = center.getY()-zona.getN()/2+radius;
        System.out.println("tempCenterX = " + tempCentrX + "tempCenterY = " + tempCentrY);
       
        int y;
        while (tempCentrX - radius< zona.getRightBorder()) {
          
            Polygon ss = new Polygon(edgeNumber);

            for (int i = 0; i < edgeNumber; i++) {
                ss.getPoints().add(new Point((int) (tempCentrX + radius * Math.cos(angle * (Math.PI) / 180)),
                        (int) (tempCentrY + radius * Math.sin(angle * (Math.PI) / 180))));
//                g.drawLine((int) (tempCentrX + radius * Math.cos(angle * (Math.PI) / 180)), (int) (tempCentrY + radius * Math.sin(angle * (Math.PI) / 180)), tempCentrX, tempCentrY);
                angle = angle + 360 / edgeNumber;
            }
            g.drawPolygon(ss.getXArray(), ss.getYArray(), edgeNumber);
            y = tempCentrY;
            while (tempCentrY - radius < zona.getDownBorder()) {
            	 Polygon ss1 = new Polygon(edgeNumber);
                for (int i = 0; i < edgeNumber; i++) {
                    ss1.getPoints().add(new Point((int) (tempCentrX + radius * Math.cos(angle * (Math.PI) / 180)),
                            (int) (tempCentrY + radius * Math.sin(angle * (Math.PI) / 180))));
//                    g.drawLine((int) (tempCentrX + radius * Math.cos(angle * (Math.PI) / 180)), (int) (tempCentrY + radius * Math.sin(angle * (Math.PI) / 180)), tempCentrX, tempCentrY);
                    angle = angle + 360 / edgeNumber;
                }
              tempCentrY = tempCentrY + width;
                g.drawPolygon(ss1.getXArray(), ss1.getYArray(), edgeNumber);
            }
            tempCentrX = tempCentrX + 2*height;
            tempCentrY = y;
        }
        
        angle = 90;
        tempCentrX = (int) (center.getX()-zona.getM()/2 + a/2);
        tempCentrY = center.getY()-zona.getN()/2+radius/2;
        System.out.println("tempCenterX = " + tempCentrX + "tempCenterY = " + tempCentrY);
       
        while (tempCentrX < zona.getRightBorder()) {
          
            Polygon ss = new Polygon(edgeNumber);

            for (int i = 0; i < edgeNumber; i++) {
                ss.getPoints().add(new Point((int) (tempCentrX + radius * Math.cos(angle * (Math.PI) / 180)),
                        (int) (tempCentrY + radius * Math.sin(angle * (Math.PI) / 180))));
//                g.drawLine((int) (tempCentrX + radius * Math.cos(angle * (Math.PI) / 180)), (int) (tempCentrY + radius * Math.sin(angle * (Math.PI) / 180)), tempCentrX, tempCentrY);
                angle = angle + 360 / edgeNumber;
            }
            g.drawPolygon(ss.getXArray(), ss.getYArray(), edgeNumber);
            y = tempCentrY;
            while (tempCentrY < zona.getDownBorder()) {
            	 Polygon ss1 = new Polygon(edgeNumber);
                for (int i = 0; i < edgeNumber; i++) {
                    ss1.getPoints().add(new Point((int) (tempCentrX + radius * Math.cos(angle * (Math.PI) / 180)),
                            (int) (tempCentrY + radius * Math.sin(angle * (Math.PI) / 180))));
//                    g.drawLine((int) (tempCentrX + radius * Math.cos(angle * (Math.PI) / 180)), (int) (tempCentrY + radius * Math.sin(angle * (Math.PI) / 180)), tempCentrX, tempCentrY);
                    angle = angle + 360 / edgeNumber;
                }
              tempCentrY = tempCentrY + width;
                g.drawPolygon(ss1.getXArray(), ss1.getYArray(), edgeNumber);
            }
            tempCentrX = tempCentrX + 2*height;
            tempCentrY = y;
        }
    }
}