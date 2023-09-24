package Blackjack;
//import Objects.*;
import test.*;
import java.util.Scanner;

//import java.util.ArrayList;

//import java.util.Scanner;


public class Main {
	
	public static void main (String[] args) {

		
		// Creating a Game
		Game game = new Game(1, 1);

		game.presStart();
		game.round();





		/*Scanner scanner = new Scanner(System.in);
		Card mycard = new Card("4h");
        System.out.println("\n************************************************\n");		
        System.out.println("*** Enter to start game ***");
        scanner.nextLine();
        System.out.println("Card dealt to *Vaidas* is: ");
        System.out.println("Card dealt to *Vaidas* is: ");
        System.out.println("Card dealt to *Vaidas* is: ");
		

		
		
		
		// Testgin Area
		//TestJaime test = new TestJaime();


		//test.card();
		//test.player();
		//test.hand();
		//test.playerHand();*/

		
		TestAlvaro a = new TestAlvaro();
		a.mostrarCartas();

	}
}
