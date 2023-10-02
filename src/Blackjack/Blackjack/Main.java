package Blackjack;
//import Objects.*;
import test.*;

import java.util.Scanner;


public class Main {


	public static void main (String[] args) {
    	Scanner scnr = new Scanner(System.in);
		presStartToCreateAGame(scnr);


		// Creating a Game
		Game game = new Game(1, 1);
		game.round();

	}
	
    public static void presStartToCreateAGame(Scanner scnr){
    	System.out.println("\n************************************************\n");		
        System.out.println("*** Enter start to start game ***");
        String i;
        i = scnr.nextLine();
    }
    
	public static void test () {
		/* Here can be tested specific modules.
		*  Examples:
		*  
		*  TestJaime testj = new TestJaime();
		*  
		*  testj.card();
		*  test.player();
		*  test.hand();
		*  
		*  ---
		*  
		*  TestAlvaro testA = new TestAlvaro();
		*  testA.mostrarCartas();
		*/
	}
}
