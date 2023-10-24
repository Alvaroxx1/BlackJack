package test;

import Objects.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TestJaime {
    	// ##################
	// ## TESTING AREA //
    public void test(){

    }

    /*
     * Made by David
     */
	public void player (){
	// Test creando persons
			Player p1 = new Player("jaime", 10);
			Player p2 = new Player("Alvaro", 10);
			
			System.out.println(p1.toString());
			System.out.println(p2.toString());
			
			// Test una lista de jugadores
			ArrayList<Player> players = new ArrayList<Player>();
			
			// leer cuantos jugadores
			Scanner scannerObject = new Scanner(System.in);
			System.out.print("Ingrege cantidad de jugadores: " );
			int numberOfPlayers = scannerObject.nextInt();
			
			// asignar los jugadores
			for (int counter = 0; counter < numberOfPlayers; counter++) {
				System.out.println("Player " + (counter + 1) + ":");
				System.out.println("Nombre: ");
				String nombre = scannerObject.next();
				System.out.println("Balance: ");
				int balance = scannerObject.nextInt();
				
				// Adding to array players
				players.add(new Player(nombre, balance));		
		     } 
			scannerObject.close();
			
			// Imprimiento array de jugadores
			for (Player num : players) { 		      
		           System.out.println(num); 		
		      }
		}

    /*
     * Made by Alvaro
     */
    public void card(){
		Card mycard = new Card("4h");
		System.out.println(mycard.toString());
    }
    
    public void hand() {
    	Card onecard = new Card("2h");
    	Card twocard = new Card("3h");
    	Card threecard = new Card("4h");
    	
    	Hand myhand = new Hand();
    	
    	// Adding cards to hand
    	myhand.add(onecard);
    	myhand.add(twocard);
    	myhand.add(threecard);
     	// print my hand
    	System.out.println(myhand.toString());
    	
    	// cleaning hand 
    	myhand.dropAllCards();
    	
    	// Addind cards in different order
    	myhand.add(threecard);
    	myhand.add(twocard);
    	myhand.add(onecard);
    	
    	// print my hand
    	System.out.println(myhand.toString());
    }
    
    public void playerHand() {
    	System.out.println(" ");
    	
		Player p = new Player("jaime", 10);
		
		p.add(new Card("4h"));
		p.add(new Card("5d"));
		p.add(new Card("7h"));

		
		System.out.println(p.toString());
    	System.out.println(p.getCards().toString());
    }
}
