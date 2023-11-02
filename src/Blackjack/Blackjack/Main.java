package Blackjack;
//import Objects.*;
import test.*;

import java.util.Scanner;


public class Main {
	public static Boolean verbose = false; // for debugging option
	public static void main (String[] args) {
		// Creating a Game
		Game game = new Game(1, 1);
		game.rounds(10); // max number of round on this game.

	}
	
    public static String scannerObjectString(/*Scanner scnr*/){
    	Scanner scnr = new Scanner(System.in);
        String s = scnr.nextLine();

		// this scanner should be closed and open when calling this method
		// but it is not working in that way.
		// scnr.close();
        return s;
    }

	public static void wait(int ms)
	{
		try
		{
			Thread.sleep(ms);
		}
	    catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
	    }
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
