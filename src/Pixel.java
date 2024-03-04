// Every pixel has a Point of Origin (PoO):
// This will be used to place and move the pixel
// Every pixel is just a drawn and filled polygon
// Every pixel holds 5 points: 4 corners and PoO
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Pixel extends JComponent {
    private Point PoO;
    private int pixelSize;
    private Point[] corners = new Point[4];
    private Color color;
    private Polygon poly = new Polygon();
    Pixel here;

    // Takes in:
    // Point -> Which will be used for PoO
    // Color -> Color of the pixel
    // pxlSize -> used to determine size of polygon
    public Pixel(Point point, Color color, int pxlSize){
        here = this;
        this.pixelSize = pxlSize;
        this.PoO = new Point(point.getX(), point.getY());
        this.color = color;
        // Attempted to keep construction relative so that
        // Enlarging the pixel size would still function
        // Well across sprites
        poly.addPoint(PoO.getX() - pixelSize, PoO.getY() - pixelSize);
        int x1, y1;
        poly.addPoint(PoO.getX() + pixelSize, PoO.getY() - pixelSize);
        poly.addPoint(PoO.getX() + pixelSize, PoO.getY() + pixelSize);
        poly.addPoint(PoO.getX() - pixelSize, PoO.getY() + pixelSize);
    }
    // Moves the polygon based on the inputted point
    public void translate(int dx, int dy){
        int tempX = PoO.getX();
        int tempY = PoO.getY();
        PoO.setX(PoO.getX() + dx);
        PoO.setY(PoO.getY() + dy);
        poly.translate(PoO.getX() - tempX, PoO.getY() - tempY);
    }
    // Will be used to paint each polygon individually
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g.fillPolygon(poly);
    }
    // Changes the color of the pixel
    public void changeColor(Color color){
        this.color = color;
    }
    // A hold over from something I wanted to use to determine collision
    public Rectangle2D returnBoundary(){
        return poly.getBounds2D();
    }
}
