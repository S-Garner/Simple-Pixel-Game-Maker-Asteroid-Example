// The building blocks
// Holds every point two points that
// Used for the pixels, which are used for the Schematics, which are used for the Sprites
public class Point {
    private int x, y;
    public Point(int dx, int dy){
        this.x = dx;
        this.y = dy;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
