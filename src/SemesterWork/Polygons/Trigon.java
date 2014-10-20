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
public class Trigon extends Applet {

    public final int edgeNumber = 3;
<<<<<<< HEAD
    public int radius = 19;
=======
    public int radius = 30;
>>>>>>> a40f042ad0b97dcacdfb9361cafbeabbf0e4a3d0
    double angle = 0;
    public Polygon polygon = new Polygon(edgeNumber);
    Scanner sc = new Scanner(System.in);
    //int m = sc.nextInt();
    //int n = sc.nextInt();
    public OurSquare zona = new OurSquare(500, 500);


    public void paint(Graphics g) {
//        setSize(new Dimension(1366, 768));
        setIgnoreRepaint(true);
        Point center = new Point(getWidth() / 2, getHeight() / 2);
//      g.drawOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
        for (int i = 0; i < edgeNumber; i++) {
            polygon.getPoints().add(new Point((int) (center.getX() + radius * Math.cos(angle * (Math.PI) / 180)),
                    (int) (center.getY() + radius * Math.sin(angle * (Math.PI) / 180))+1));
            angle = angle + 360 / edgeNumber;
        }
//        g.drawPolygon(polygon.getXArray(), polygon.getYArray(), polygon.getEdgeNumber());


//        zona.setM(m);
//        zona.setN(n);
        zona.addPointsForDraw(center);
        g.drawPolygon(zona.getXArray(), zona.getYArray(), zona.EDGE);

        double x1 = polygon.getPoints().get(0).getX();
        double x2 = polygon.getPoints().get(1).getX();
        double y1 = polygon.getPoints().get(0).getY();
        double y2 = polygon.getPoints().get(1).getY();
        double a = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        
//        int TempCenrX = center.getX();
//        while (TempCenrX < zona.getUpBorder()) {
//            TempCenrX = TempCenrX +
//        }

        double width;
        double height;
        angle = 30;
        if ((radius > 17) || (radius == 15)){
        	width = (radius + (Math.sqrt((radius * radius) - (a/2)*(a/2))));
            height = (Math.sqrt((radius * radius) - (radius / 2) * (radius / 2)));
        }
        else{
        	width = (radius + 1 + (Math.sqrt((radius * radius) - (a/2)*(a/2))));
            height = ((-1) + Math.sqrt((radius * radius) - (radius / 2) * (radius / 2)));
        }
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
                tempCentrY = (int) (tempCentrY + width);
                g.drawPolygon(ss1.getXArray(), ss1.getYArray(), edgeNumber);
            }
            tempCentrX = (int) (tempCentrX + 2*height);
            tempCentrY = y;
        }
        
        angle = 90;
        tempCentrX = (int) (center.getX()-zona.getM()/2 + a/2);
        tempCentrY = center.getY()-zona.getN()/2+radius/2;
        System.out.println("tempCenterX = " + tempCentrX + "tempCenterY = " + tempCentrY);
       
        while (tempCentrX - a/2 < zona.getRightBorder()) {
          
            Polygon ss = new Polygon(edgeNumber);

            for (int i = 0; i < edgeNumber; i++) {
                ss.getPoints().add(new Point((int) (tempCentrX + radius * Math.cos(angle * (Math.PI) / 180)),
                        (int) (tempCentrY + radius * Math.sin(angle * (Math.PI) / 180))));
//                g.drawLine((int) (tempCentrX + radius * Math.cos(angle * (Math.PI) / 180)), (int) (tempCentrY + radius * Math.sin(angle * (Math.PI) / 180)), tempCentrX, tempCentrY);
                angle = angle + 360 / edgeNumber;
            }
            g.drawPolygon(ss.getXArray(), ss.getYArray(), edgeNumber);
            y = tempCentrY;
            while (tempCentrY - a/2< zona.getDownBorder()) {
            	 Polygon ss1 = new Polygon(edgeNumber);
                for (int i = 0; i < edgeNumber; i++) {
                    ss1.getPoints().add(new Point((int) (tempCentrX + radius * Math.cos(angle * (Math.PI) / 180)),
                            (int) (tempCentrY + radius * Math.sin(angle * (Math.PI) / 180))));
//                    g.drawLine((int) (tempCentrX + radius * Math.cos(angle * (Math.PI) / 180)), (int) (tempCentrY + radius * Math.sin(angle * (Math.PI) / 180)), tempCentrX, tempCentrY);
                    angle = angle + 360 / edgeNumber;
                }
              tempCentrY = (int) (tempCentrY + width);
                g.drawPolygon(ss1.getXArray(), ss1.getYArray(), edgeNumber);
            }
            tempCentrX = (int) (tempCentrX + 2*height);
            tempCentrY = y;
        }
    }
}