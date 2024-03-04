// Heart of the game play

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class GameFrame extends JPanel{
    // In Class enum
    enum AstroidSizes{
        SMALL,
        MEDIUM,
        LARGE
    }
    // Finals for the display width, height, and side bumpers
    final int PANEL_WIDTH = 1080,
            PANEL_HEIGHT = 720,
            RIGHT = PANEL_WIDTH,
            LEFT = 32,
            TOP = 0,
            BOTTOM = PANEL_HEIGHT,
            MARGIN = 10;
    // Delay for timers
    final int DELAY = 10;
    // Change this if you want to make the pixels larger
    final int PXL_SIZE = 2;

    // Enum Variable
    AstroidSizes astros;

    // Will hold all of the created asteroid sprites
    ArrayList<Sprites> asteroids;
    // Used for generating and displaying asteroids
    ArrayList<Point> asteroidPoints;
    Schematics asteroidS;
    Schematics asteroidM;
    Schematics asteroidL;
    Color astColor;

    Sprites rocket;
    Point rocketPoint;
    Schematics rocketS;
    Color rocketColor;

    GameFrame here;

    ArrayList<Sprites> laser;
    Schematics laserScheme;
    Point laserPoint;
    ArrayList<Point> laserPoints;
    Color laserColor;

    Point tempPoint;
    // Holds all background elements to display
    Background background;

    public boolean mousePressed = false;
    // Used to "control"
    public boolean timedOut = true;

    public GameFrame(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(new Color(20, 20, 36));
        here = this;
        tempPoint = new Point(0,0);

        // First create a color you want
        // Next, make the point where you want object (rocket) to appear
        // Initialize Schematic
        // Chose what schema you want your sprite to have
        // Assign the point and schema to project
        // Add component to this Panel
        rocketColor = new Color(235, 230, 143);
        rocketPoint = new Point(100,100);
        rocketS = new Schematics();
        rocketS.schemaSelection(rocketColor,PXL_SIZE,"Ship");
        rocket = new Sprites(rocketPoint, rocketS);
        this.add(rocket);

        astColor = new Color(105, 49, 41);
        asteroidPoints = new ArrayList<>();
        asteroidS = new Schematics();
        asteroidM = new Schematics();
        asteroidL = new Schematics();
        // Will store the schemas, but will assign at the timer, using random
        asteroidS.schemaSelection(astColor, PXL_SIZE, "Small Asteroid");
        asteroidM.schemaSelection(astColor, PXL_SIZE, "Medium Asteroid");
        asteroidL.schemaSelection(astColor, PXL_SIZE, "Large Asteroid");
        // Will be used to store the asteroids
        asteroids = new ArrayList<>();

        // Same design as the asteroids, but will be generated when clicked
        laserColor = new Color(134, 176, 170);
        laserPoints = new ArrayList<>();
        laserScheme = new Schematics();
        laserScheme.schemaSelection(laserColor, PXL_SIZE,"Laser");
        laser = new ArrayList<>();

        // Take background component and assign it to this panel
        background = new Background();
        for (int i = 0; i < background.getBgSprites().size(); i++){
            this.add(background.getBgSprites().get(i));
        }

        // Timer for generating asteroids
        Timer spawnT = new Timer(DELAY + 1000, event -> {
            Schematics tempScheme = new Schematics();
            Random rand = new Random();
            // Greater chance of small asteroid
            //
            int randO = rand.nextInt(21);
            if (randO <= 3)
            {
                astros = AstroidSizes.LARGE;
            }
            else if (randO <= 7 && randO > 3)
            {
                astros = AstroidSizes.MEDIUM;
                //tempScheme = asteroidL;
            }
            else
            {
                astros = AstroidSizes.SMALL;
                //tempScheme = asteroidS;
            }
            switch(astros){
                case SMALL:
                    tempScheme = asteroidS;
                    break;
                case MEDIUM:
                    tempScheme = asteroidM;
                    break;
                case LARGE:
                    tempScheme = asteroidL;
                    break;
            }
            // Create new sprite to array, which is added to panel
            asteroidPoints.add(new Point(PANEL_WIDTH + 100, 600));
            asteroidPoints.get(asteroidPoints.size() - 1).setY((int)(Math.random() * (PANEL_HEIGHT / 5)) * 5);
            asteroids.add(new Sprites(asteroidPoints.get(asteroidPoints.size() - 1), tempScheme));
            this.add(asteroids.get(asteroids.size() - 1));
        });
        spawnT.start();

        // Used to assist with stopping the laser from just continuously firing
        Timer timerTimeOut = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timedOut = (!timedOut);
            }
        });
        timerTimeOut.start();

        // Will generate the laser, and will also be the checker for meteor hit
        Timer laserT = new Timer(DELAY, event -> {
            if (mousePressed && timedOut == false){
                laserPoints.add(new Point(rocket.getPoO().getX(), rocket.getPoO().getY()));
                laser.add(new Sprites(laserPoints.get(laserPoints.size() - 1), laserScheme));
                this.add(laser.get(laser.size() - 1));
                int x1, y1, x2, y2;
                for (int i = 0; i < asteroids.size(); i++){
                    if (asteroids.isEmpty()){
                        break;
                    }
                    x1 = asteroids.get(i).getPoO().getX();
                    y1 = asteroids.get(i).getPoO().getY();
                    for (int j = 0; j < laser.size(); j++){
                        x2 = laser.get(j).getPoO().getX();
                        y2 = laser.get(j).getPoO().getY();
                        double distance = Math.sqrt(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
                    }
                }

                for (int i = 0; i < laser.size(); i++){
                    if (asteroids.isEmpty()){
                        break;
                    }
                    x1 = laser.get(i).getPoO().getX();
                    y1 = laser.get(i).getPoO().getY();
                    for (int j = 0; j < asteroids.size(); j++){
                        x2 = asteroids.get(j).getPoO().getX();
                        y2 = asteroids.get(j).getPoO().getY();
                        double distance = Math.sqrt(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
                        if (distance <= 5){
                            this.remove(asteroids.get(j));
                            asteroids.remove(j);
                            repaint();
                            this.repaint();
                            here.repaint();
                        }
                    }
                }
            }
        });
        laserT.start();

        // Moves the laser across the screen
        Timer laserMover = new Timer(DELAY, event ->{
           for (int i = 0; i < laser.size(); i++){
               laser.get(i).translate(5, 0);
               repaint();
               this.repaint();
               here.repaint();
           }
        });
        laserMover.start();

        // Moves the asteroids
        Timer t = new Timer(DELAY, event -> {
            for (int i = 0; i < asteroids.size(); i++){
                asteroids.get(i).translate(-1, 0);
                repaint();
                this.repaint();
                here.repaint();
            }
        });
        t.start();

        // Moves the ship
        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        rocket.translate(0, -5); //Moves up by 5 pixels
                        break;
                    case KeyEvent.VK_S:
                        rocket.translate(0, 5); //Moves down by 5 pixels
                        break;
                }
                repaint();
            }

            public void keyReleased(KeyEvent e) {
            }
        });
        this.setFocusable(true);

        this.addMouseListener(new LaserListener());
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    // Function to print laser
    private class LaserListener implements MouseListener {
        @Override
        public void mousePressed(MouseEvent e) {
            mousePressed = true;
            repaint();
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            mousePressed = false;
            repaint();
        }
        @Override
        public void mouseClicked(MouseEvent e) { }
        @Override
        public void mouseEntered(MouseEvent e) { }
        @Override
        public void mouseExited(MouseEvent e) { }
    }

    private class NotListening implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    // Paint all elements onto screen
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        for (int i = 0; i < background.getBgSprites().size(); i++){
            background.getBgSprites().get(i).paint(g2);
        }
        for (int i = 0; i < asteroids.size() - 1; i++){
            asteroids.get(i).paint(g2);
        }
        for(int i = 0; i < laser.size() - 1; i++){
            laser.get(i).paint(g2);
        }
        rocket.paint(g2);
    }
}