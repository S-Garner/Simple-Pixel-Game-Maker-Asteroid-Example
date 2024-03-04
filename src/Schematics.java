/*
    This were sprites are predeterimed and laid out.
    Want to make one of your own pixel art for ship or asteroids?
    Google sheet with instructions on Coordinates sheet:
    https://docs.google.com/spreadsheets/d/1nmD4Pm4kZO8SKtioPACplZ45STNdtsEIYknDI4sfvCs/edit?usp=sharing
*/
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Schematics extends JComponent {
    Color color;
    int pxlSize;
    Point PoO;
    public int getPxlSize() {
        return pxlSize;
    }
    public Color getColor() {
        return color;
    }
    // Hold over
    public ArrayList<Parameters> getFrames() {
        return frames;
    }
    public Point getPoO() {
        return PoO;
    }
    // Hold over from animator
    public int getNumFrames() {
        return numFrames;
    }

    public void setNumFrames(int numFrames) {
        this.numFrames = numFrames;
    }

    private int numFrames;
    ArrayList<Parameters> frames = new ArrayList<Parameters>();
    public Schematics(){}

    // General structure of Schemes:
    // An array of ints, used to store coordinates
    // pxls0 is the coordinates based of the PoO (Central Point)
    // add pixel array to pxls which will be used to make sprites
    public void ship(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{-1, -9, -3, -7, 1, -7, 3, -7, 5, -7, 7, -7, -3, -5, 5, -5, 7, -5, 9, -5, 11, -5, -3, -3, 7, -3, -1, -1, 5, -1, -3, 1, 7, 1, -3, 3, 5, 3, 7, 3, 9, 3, 11, 3, -3, 5, 1, 5, 3, 5, 5, 5, 7, 5, -1, 7};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void tinyStar(Color color, int pixlSize){
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{1, 1};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void smallStar(Color color, int pixlSize){
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{3, -3, 1, -1, 5, -1, 3, 1};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void largeStar(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{1, -5, -1, -3, 1, -3, 3, -3, -3, -1, -1, -1, 1, -1, 3, -1, 5, -1, -1, 1, 1, 1, 3, 1, 1, 3};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void smallAsteroid(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{-3, -7, -1, -7, 1, -7, 3, -7, -3, -5, 5, -5, -5, -3, -1, -3, 7, -3, -3, -1, 3, -1, 7, -1, -5, 1, 5, 1, -5, 3, 7, 3, -5, 5, 1, 5, 7, 5, -3, 7, 5, 7, -1, 9, 1, 9, 3, 9};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void mediumAsteroid(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{1, -15, 3, -15, 1, -13, 5, -13, -1, -11, 7, -11, 9, -11, -3, -9, 3, -9, 11, -9, -5, -7, 9, -7, -7, -5, 7, -5, -7, -3, 3, -3, 7, -3, -9, -1, -3, -1, 7, -1, -9, 1, 7, 1, -9, 3, 9, 3, -7, 5, -5, 5, 9, 5, -3, 7, -1, 7, 7, 7, 9, 7, 1, 9, 3, 9, 5, 9};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void largeAsteroid(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{-1, -19, 1, -19, 3, -19, -7, -17, -5, -17, -3, -17, 5, -17, -9, -15, 1, -15, 7, -15, -11, -13, 9, -13, 11, -13, -11, -11, 15, -11, -15, -9, 1, -9, 15, -9, -17, -7, -9, -7, -1, -7, 3, -7, 15, -7, -17, -5, 1, -5, 5, -5, 17, -5, -17, -3, 3, -3, 17, -3, -15, -1, 15, -1, -15, 1, 15, 1, -11, 3, 11, 3, -17, 5, -15, 5, -5, 5, -3, 5, 7, 5, 11, 5, -17, 7, -7, 7, -1, 7, 15, 7, -17, 9, -7, 9, 1, 9, 17, 9, -15, 11, -5, 11, -3, 11, -1, 11, 17, 11, -11, 13, 17, 13, -9, 15, 1, 15, 9, 15, 11, 15, 15, 15, -9, 17, -7, 17, 5, 17, 7, 17, -5, 19, -3, 19, -1, 19, 1, 19, 3, 19};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void laser(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{7, -3, 1, -1, 3, -1, 5, -1, 9, -1, 7, 1};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void moon(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{-3, -11, -1, -11, 1, -11, 3, -11, 5, -11, 3, -9, 7, -9, 9, -9, 5, -7, 11, -7, -11, -5, 7, -5, 15, -5, -11, -3, 7, -3, 15, -3, -15, -1, -11, -1, 7, -1, 17, -1, -15, 1, -11, 1, 5, 1, 17, 1, -15, 3, -9, 3, 5, 3, 17, 3, -15, 5, -9, 5, 1, 5, 3, 5, 17, 5, -15, 7, -7, 7, -5, 7, -3, 7, -1, 7, 17, 7, -11, 9, 15, 9, -11, 11, 15, 11, -9, 13, 11, 13, -7, 15, -5, 15, 7, 15, 9, 15, -3, 17, -1, 17, 1, 17, 3, 17, 5, 17};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void zero(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{-1, -5, 1, -5, -3, -3, 3, -3, -3, -1, 3, -1, -3, 1, 3, 1, -3, 3, 3, 3, -1, 5, 1, 5};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void two(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{-1, -5, 1, -5, -3, -3, 3, -3, 3, -1, 1, 1, -1, 3, -3, 5, -1, 5, 1, 5, 3, 5};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void one(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{-1, -5, 1, -5, -3, -3, 1, -3, 1, -1, 1, 1, 1, 3, -3, 5, -1, 5, 1, 5, 3, 5};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void three(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{-1, -5, 1, -5, -3, -3, 3, -3, 1, -1, 3, -1, 3, 1, -3, 3, 3, 3, -1, 5, 1, 5};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void four(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{1, -5, -1, -3, 1, -3, -3, -1, 1, -1, -3, 1, -1, 1, 1, 1, 3, 1, 1, 3, 1, 5};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void five(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{-3, -5, -1, -5, 1, -5, 3, -5, -3, -3, -3, -1, -1, -1, 1, -1, 3, 1, -3, 3, 3, 3, -1, 5, 1, 5};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void six(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{-1, -5, 1, -5, -3, -3, 3, -3, -3, -1, -3, 1, -1, 1, 1, 1, 3, 1, -3, 3, 3, 3, -1, 5, 1, 5};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void seven(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{-3, -5, -1, -5, 1, -5, 3, -5, -3, -3, 3, -3, 1, -1, -1, 1, -3, 3, -3, 5};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void eight(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{-1, -5, 1, -5, 3, -5, -3, -3, 3, -3, -3, -1, 1, -1, -1, 1, 1, 1, 3, 1, -3, 3, 3, 3, -3, 5, -1, 5, 1, 5};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void nine(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{-1, -5, 1, -5, -3, -3, 3, -3, -3, -1, -1, -1, 1, -1, 3, -1, 3, 1, -3, 3, 3, 3, -3, 5, -1, 5, 1, 5};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }
    public void changePoO(Point point){
        PoO = point;
    }
    // When you make schematic, you will use the color you want, the size of pixel, and a string of the scheme you want
    // It will then go that schema and assign it to this
    // This will be used to actually make the sprites
    public void schemaSelection(Color color, int pixlSize, String userSelect) throws IllegalArgumentException {
        switch (userSelect){
            case "Large Star":
                largeStar(color, pixlSize);
                break;
            case "Small Star":
                smallStar(color, pixlSize);
                break;
            case "Tiny Star":
                tinyStar(color, pixlSize);
                break;
            case "Ship":
                ship(color, pixlSize);
                break;
            case "Small Asteroid":
                smallAsteroid(color, pixlSize);
                break;
            case "Medium Asteroid":
                mediumAsteroid(color, pixlSize);
                break;
            case "Large Asteroid":
                largeAsteroid(color, pixlSize);
                break;
            case "Laser":
                laser(color, pixlSize);
                break;
            case "Moon":
                moon(color, pixlSize);
                break;
            default:
                throw new IllegalArgumentException("Schematic not found");
        }
    }
}

/*
        Template of schematic

        public void two(Color color, int pixlSize){
        numFrames = 1;
        ArrayList<int[]> pxls = new ArrayList<int[]>();
        this.pxlSize = pixlSize;
        this.color = color;
        int[] pxls0 = new int[]{Add Coordinates here};
        pxls.add(pxls0);
        for (int i = 0; i < numFrames; i++) {
            frames.add(new Parameters());
            frames.get(i).coordinates = pxls.get(i);
        }
    }





 */