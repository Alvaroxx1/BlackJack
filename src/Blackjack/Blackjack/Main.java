package Blackjack;
//import Objects.*;
import test.*;
import java.util.Scanner;

//import java.util.ArrayList;

import java.util.Scanner;


public class Main {
	
	public static void main (String[] args) {

		Scanner scanner = new Scanner(System.in);
		// Creating a Game
        System.out.println("\n************************************************\n");		
        System.out.println("*** Enter start to start game ***");
        scanner.nextLine();		
		Game game = new Game(1, 1);

		game.presStart();
		game.round();






		

		
		
		
		// Testgin Area
		//TestJaime test = new TestJaime();


		//test.card();
		//test.player();
		//test.hand();
		//test.playerHand();*/

		
//		TestAlvaro a = new TestAlvaro();
//		a.mostrarCartas();

	}
}
