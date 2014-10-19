import java.applet.Applet;
import java.awt.*;
import java.util.Scanner;

/**
 * Created by Rigen on 18.10.14.
 */
public class Paint extends Applet {

    public int edgeNumber = 6;
    public int radius = 22;
    double angle = 0;
    public Polygon polygon = new Polygon(edgeNumber);
    public OurSquare zona = new OurSquare();
    Scanner sc = new Scanner(System.in);


    public void paint(Graphics g) {
//        setSize(new Dimension(700, 700));
        setIgnoreRepaint(true);
        Point center = new Point(getWidth() / 2, getHeight() / 2);
//        g.drawOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
        for (int i = 0; i < edgeNumber; i++) {
            polygon.getPoints().add(new Point((int) (center.getX() + radius * Math.cos(angle * (Math.PI) / 180)),
                    (int) (center.getY() + radius * Math.sin(angle * (Math.PI) / 180))));
            angle = angle + 360 / edgeNumber;
        }
        g.drawPolygon(polygon.getXArray(), polygon.getYArray(), polygon.getEdgeNumber());


//        angle = 180;
//        radius = 22;
//        zona.setM(sc.nextInt());
//        zona.setN(sc.nextInt());
//        zona.setM(450);
//        zona.setN(350);
//        for (int i = 0; i < 4; i++) {
//            zona.getPoints().add(new Point((int)(center.getX() + ((zona.getN())/2) + (radius * Math.cos(angle * (Math.PI)/180))), (int)(center.getY() + (zona.getM()/2) + radius * Math.sin(angle * (Math.PI)/180))));
//            angle = angle + 360/4;
//        }
//        g.drawPolygon(zona.getXArray(), zona.getYArray(), 4);

        zona.setM(sc.nextInt());
        zona.setN(sc.nextInt());
        zona.addPointsForDraw(center);
        g.drawPolygon(zona.getXArray(), zona.getYArray(), zona.EDGE);
        //polygon.areaPolygon(polygon);

//        System.out.println("Right border " + zona.getRightBorder());
//        System.out.println("Left border " + zona.getLeftBorder());
//        System.out.println("Up border " + zona.getUpBorder());
//        System.out.println("Down border " + zona.getDownBorder());

//        int TempCenrX = center.getX();
//        while (TempCenrX < zona.getUpBorder()) {
//            TempCenrX = TempCenrX +
//        }

        angle = 0;
        int width = (int)(Math.sqrt((radius * radius) - (radius / 2) * (radius / 2)));
        int  tempCentrY = center.getY();
        System.out.println("y centr temp" + tempCentrY);
        System.out.println("down border" + zona.getDownBorder());

        while (tempCentrY < zona.getDownBorder()) {
            tempCentrY = tempCentrY + 2*width;
            Polygon ss = new Polygon(edgeNumber);

            for (int i = 0; i < 6; i++) {
                ss.getPoints().add(new Point((int) (center.getX() + radius * Math.cos(angle * (Math.PI) / 180)),
                        (int) (tempCentrY + radius * Math.sin(angle * (Math.PI) / 180))));
                angle = angle + 360 / edgeNumber;
            }
            g.drawPolygon(ss.getXArray(),ss.getYArray(), 6);
        }
    }


    public static void main(String[] args) {
//        Paint p = new Paint();
//        p.setSize(new Dimension(1000, 1000));
    }
}
