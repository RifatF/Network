import java.applet.Applet;
import java.awt.*;
import java.util.Scanner;

/**
 * Created by Rigen on 18.10.14.
 */
public class Paint extends Applet {

    public int edgeNumber = 5;
    public int radius = 100;
    double angle = 270;
    public Polygon polygon = new Polygon(edgeNumber);
    public OurSquare zona = new OurSquare();
    Scanner sc = new Scanner(System.in);


    public void paint(Graphics g) {
//        setSize(new Dimension(700, 700));
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
        polygon.areaPolygon(polygon);
    }

    public static void main(String[] args) {
//        Paint p = new Paint();
//        p.setSize(new Dimension(1000, 1000));
    }
}
