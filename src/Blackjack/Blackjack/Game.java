package Blackjack;

import Objects.*;
import java.util.ArrayList;

public class Game {

    Dealer dealer = new Dealer();
    Deck deck = new Deck();
    ArrayList<Player> players = new ArrayList<Player>();
    
	// Constructor
    public Game(int number_players, int number_deck){    	
    	// Creating n players 
        for (int i = 0; i < number_deck; i++){
            this.players.add(new Player());
        }
    }	

    public void presStart(){
        System.out.println("Press enter to start.(skipped)"); 
    }
    
    // only one round for this hw1
    public void round() {
    	int countround = 0;
    	while (countround < 1){
    		
    		// dealer give card to player
    		
    		dealer.cardToPlayer(players.get(0), this.deck);

    		// dealer give card to dealer
    		dealer.cardToDealer(this.deck);
    		
    		// dealer give card to player
    		dealer.cardToPlayer(players.get(0), this.deck);
    		
    		// Table view
    		tableView(this.dealer, this.players);
    		
    		
    		// just print none
    		System.out.println("\nnone");
    		
    		// numeros de rondas para HW1 
    		countround++;
    	}
    }
    
    public static void tableView(Dealer dealer, ArrayList<Player> players) {
    	System.out.println("\n*** Table view***");
    	
    	// Print dealers hand
    	System.out.println("Dealer has: " + dealer.getCards().toString() + " [Score: null]");
    	
    	// Print Players hands
		for (Player player : players) { 		      
	           System.out.println("Player *" + player.getName() + "* has: " + player.getCards() + " [Score: null]."); 		
	      }
    }
}
