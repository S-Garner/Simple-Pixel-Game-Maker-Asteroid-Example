// The sprites is made of:
// A schematic that tells where all the points need to go
// The Pixels contain points
// The sprite itself is responsible for painting itself

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Sprites extends JPanel implements MoveableObject{
    final int DELAY = 10;
    //private ArrayList<Pixel> pxels = new ArrayList<Pixel>();
    private ArrayList<internalFrames> intFrames = new ArrayList<internalFrames>();
    private Color color;
    private Point PoO;
    private Sprites here;

    // Will be used when we actually know what scheme we want to make
    public Sprites(Point point, Schematics schema) {
        scheme = schema;
        mainFrames = scheme.getFrames();
        here = this;
        this.PoO = point;
        this.color = scheme.getColor();
        Point tempPoint = new Point(0,0);
        for (int i = 0; i < scheme.getNumFrames(); i++){
            intFrames.add(new internalFrames());
            for (int j = 0; j < scheme.getFrames().get(i).coordinates.length; j = j + 2){
                tempPoint.setX(PoO.getX() + (scheme.getPxlSize() * mainFrames.get(i).coordinates[j]));
                tempPoint.setY(PoO.getY() + (scheme.getPxlSize() * mainFrames.get(i).coordinates[j + 1]));
                intFrames.get(i).pxels.add(new Pixel(tempPoint, color,scheme.getPxlSize()));
            }
        }
    }
    private Schematics scheme;
    ArrayList<Parameters> mainFrames;
    class internalFrames{
        ArrayList<Pixel> pxels = new ArrayList<Pixel>();
    }
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paint(g2);
        g2.setColor(color);
        for (int h = 0; h < scheme.getNumFrames(); h++) {
            for (int i = 0; i < intFrames.get(h).pxels.size(); i++) {
                intFrames.get(h).pxels.get(i).paint(g2);
            }
        }
    }
    public void translate(int dx, int dy) {
        int tempX = PoO.getX();
        int tempY = PoO.getY();
        PoO.setX(PoO.getX() + dx);
        PoO.setY(PoO.getY() + dy);
        for (int h = 0; h < scheme.getNumFrames(); h++) {
            for (int i = 0; i < intFrames.get(h).pxels.size(); i++) {
                intFrames.get(h).pxels.get(i).translate(PoO.getX() - tempX, PoO.getY() - tempY);
            }
        }
    }
    public ArrayList<Rectangle> spriteBounds(){
        ArrayList<Rectangle> rectArray = new ArrayList<Rectangle>();
        for (int h = 0; h < scheme.getNumFrames(); h++) {
            for (int i = 0; i < intFrames.get(h).pxels.size(); i++) {
                rectArray.add(intFrames.get(h).pxels.get(i).getBounds());
            }
        }
        return rectArray;
    }
    public Point getPoO(){
        return PoO;
    }
}