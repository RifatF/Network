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
    int m = sc.nextInt();
    int n = sc.nextInt();
    
    public void paint(Graphics g) {
        setSize(new Dimension(1366, 768));
        Point center = new Point(getWidth() / 2, getHeight() / 2);
        
        zona.setM(m);
        zona.setN(n);
        for (int i = 0; i < 4; i++) {
            zona.getPoints().add(new Point((int)(center.getX()-zona.getM()/2), (int)(center.getY()-zona.getN()/2)));
            zona.getPoints().add(new Point((int)(center.getX()+zona.getM()/2), (int)(center.getY()-zona.getN()/2)));
            zona.getPoints().add(new Point((int)(center.getX()+zona.getM()/2), (int)(center.getY()+zona.getN()/2)));
            zona.getPoints().add(new Point((int)(center.getX()-zona.getM()/2), (int)(center.getY()+zona.getN()/2)));
        }
        g.drawPolygon(zona.getXArray(), zona.getYArray(), 4);
        
//        g.drawOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);
        for (int i = 0; i < edgeNumber; i++) {
            polygon.getPoints().add(new Point((int) (center.getX() + radius * Math.cos(angle * (Math.PI) / 180)),
                    (int) (center.getY() + radius * Math.sin(angle * (Math.PI) / 180))));
            angle = angle + 360 / edgeNumber;
        }
        g.drawPolygon(polygon.getXArray(), polygon.getYArray(), polygon.getEdgeNumber());
        polygon.areaPolygon(polygon);
    }
}
