import javax.swing.text.TabableView;
import java.util.Scanner;

public class TowersOfHanoi {

    public static void main(String args[]){
        int numberOfDiscs = 0;
        int numberOfMoves = 0;
        int rodFrom, rodTo;
        boolean gameEnded = false;
        Scanner scnr = new Scanner(System.in);

        do
        {
            System.out.println("Please input the number of discs (max 6):");
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
}
