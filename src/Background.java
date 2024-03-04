// Contains and creates all the sprites for background
// Randomly generates stars to create a new background each time
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Background extends JComponent {
    final int TINY_STAR_AMOUNT = 20, SMALL_STAR_AMOUNT = 12, LARGE_STAR_AMOUNT = 35, PANEL_WIDTH = 1080, PANEL_HEIGHT = 720, PXL_SIZE = 2;

    ArrayList<Sprites> bgSprites;
    Sprites moon;

    ArrayList<Point> starPoints;
    Point moonPoint;

    Color starColor;
    Color moonColor;

    ArrayList<Schematics> starSchemes;
    Schematics moonScheme;

    public Background(){
        Random rand = new Random();
        int randoX, randoY;

        bgSprites = new ArrayList<>();

        starColor = new Color(212, 210, 127);
        moonColor = new Color(237, 211, 123);

        starSchemes = new ArrayList<>();

        starSchemes.add(new Schematics());
        starSchemes.add(new Schematics());
        starSchemes.add(new Schematics());

        starSchemes.get(0).schemaSelection(starColor, PXL_SIZE, "Tiny Star");
        starSchemes.get(1).schemaSelection(starColor, PXL_SIZE, "Small Star");
        starSchemes.get(2).schemaSelection(starColor, PXL_SIZE, "Large Star");

        starPoints = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < TINY_STAR_AMOUNT; i++){
            randoX = rand.nextInt(PANEL_WIDTH - 30);
            randoY = rand.nextInt(PANEL_HEIGHT + 20);
            starPoints.add(new Point(randoX, randoY));
            bgSprites.add(new Sprites(starPoints.get(i), starSchemes.get(0)));
        }
        for (int i = 0; i < SMALL_STAR_AMOUNT; i++){
            randoX = randoX = rand.nextInt(PANEL_WIDTH - 30);
            randoY = rand.nextInt(PANEL_HEIGHT + 20);
            starPoints.add(new Point(randoX, randoY));
            bgSprites.add(new Sprites(starPoints.get(starPoints.size() - 1), starSchemes.get(1)));
        }
        for (int i = 0; i < LARGE_STAR_AMOUNT; i++){
            randoX = randoX = rand.nextInt(PANEL_WIDTH - 30);
            randoY = rand.nextInt(PANEL_HEIGHT + 20);
            starPoints.add(new Point(randoX, randoY));
            bgSprites.add(new Sprites(starPoints.get(starPoints.size() - 1), starSchemes.get(2)));
        }
        moonPoint = new Point(1020, 40);
        moonScheme = new Schematics();
        moonScheme.schemaSelection(moonColor, PXL_SIZE, "Moon");
        moon = new Sprites(moonPoint, moonScheme);
        bgSprites.add(moon);
    }
    public ArrayList<Sprites> getBgSprites(){
        return bgSprites;
    }
}
