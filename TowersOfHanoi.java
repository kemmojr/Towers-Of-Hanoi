import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Scanner;
import java.applet.Applet;

public class TowersOfHanoi extends Applet implements KeyListener {

    int in = 0, to = 0, from = 0;
    int moveNum = 0;
    TowerHanoi game;
    public void paint(Graphics g){
        int numberOfDiscs = 0;
        int numberOfMoves = 0;
        int rodFrom, rodTo;
        boolean gameEnded = false;
        Scanner scnr = new Scanner(System.in);
        TowersOfHanoi main = new TowersOfHanoi();

//        numberOfDiscs = 3;
        while (true){
            numberOfDiscs = in;
            if (numberOfDiscs > 0 && numberOfDiscs < 6) {
                String p = "A game with" + numberOfDiscs + "discs";
                g.drawString(p, 100, 20);
            }
            if (numberOfDiscs == 0) {
                String p = "Please input the number of discs (max 6):";
                g.drawString(p, 100, 20);
            }

            if (numberOfDiscs != 0) {
                game = new TowerHanoi(numberOfDiscs); // initialize the game
                if (game != null) {
                    String[] p = game.stringify();
                    for (int i = 0; i < p.length; i++) {
                        g.drawString(p[i], 200, 50);
                    }
                }
            }

            if (moveNum == 0) {
                if (game != null) {
                    String[] p = game.stringify();
                    for (int i = 0; i < p.length; i++) {
                        g.drawString(p[i], 200, 50);
                    }
                }
            } else if (moveNum % 2 == 0) {
                to = in;
                String print = "Moving from " + from + " to " + to;
                g.drawString(print, 100, moveNum * 10 + 20);
                moveNum++;
            } else {
                from = in;
                moveNum++;
            }
        }
    }

    public static void main(String args[]){
        int numberOfDiscs = 0;
        int numberOfMoves = 0;
        int rodFrom, rodTo;
        boolean gameEnded = false;
        Scanner scnr = new Scanner(System.in);
        TowersOfHanoi main = new TowersOfHanoi();

        do
        {
            String msg = "Please input the number of discs (max 6):";
            String in = "";
            numberOfDiscs = Integer.parseInt(scnr.nextLine());
        }
        while ((numberOfDiscs < 1) || (numberOfDiscs > 6));

        TowerHanoi game = new TowerHanoi(numberOfDiscs); // initialize the game


        // start of the game
        System.out.println(game); // print the current state of the game on the screen
        while(!gameEnded)
        {
            System.out.println("Please input the rod to remove from (1, 2 or 3):");
            rodFrom = scnr.nextInt();
            System.out.println("Please input the rod to place onto (1, 2 or 3):");
            rodTo = scnr.nextInt();
            game.move(rodFrom, rodTo); // move should perform all the checks and only move a disc if the movement is allowed. If the movement is not allowed, display a warning message.
            numberOfMoves++;
            System.out.println(game); // print the current state of the game on the screen
            gameEnded = game.checkWin(); // checks if the 3rd rod contains all the discs.
        }
        System.out.println("The game has ended.");
        System.out.println("You required " + numberOfMoves + " to win.");

        }

    public void init(){
    addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char input = e.getKeyChar();
        in = Integer.parseInt(String.valueOf(input));
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
