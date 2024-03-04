// Seth Garner
// Main: creates JFrame, adds a game frame

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Personal Space Invader");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        GameFrame displayPanel = new GameFrame();

        frame.getContentPane().add(displayPanel);
        frame.pack();
        frame.setVisible(true);
    }
}

/*
* Classes in separate files.  Do class divisions make sense? [x]
* ~ More or less
*
* Interface for MoveableObject, implemented by Rocket and Asteroid at a minimum [x]
* - Technically applied to all objects
*
* Anonymous class for Keyboard Listeners [x]
*
* A panel that extends JPanel [x]
*
* Mouselistener as an Inner class, to shoot the laser [x]
*
* Timer that takes in a Lamba function [x]
*
* An enum of AsteroidSize: Small, Medium, Large [x]
* - Stored in GameFrame
*
* Do asteroids move automatically? [x]
*
* Does spaceship move with keyboard commands? [x]
*
* Does Laser "fire"? [x]
* ~ Sort of... Pretty janky
*
* Do asteroids disappear after getting shot with the laser? [x]
* ~ Forgive the jury rigged system, did not have enough time (or knowledge) to make it work better
*
* Do more asteroids appear as the time goes on? [x]
* - I don't think asteroids even disappear, so it could be really slow and break if left for long stretches of time
*
*
* */