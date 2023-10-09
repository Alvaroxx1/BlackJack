package Blackjack;
import java.util.ArrayList;
import Objects.*;

public class Game {
    Dealer dealer = new Dealer();
    Deck deck = new Deck();
    ArrayList<Player> players = new ArrayList<Player>();
    
	// Constructor
    public Game(int number_players, int number_deck){    	
		// press Enter to start the game
    	System.out.println("\n************************************************\n");		
        System.out.println("*** Enter start to start game ***");

		Main.scannerObjectString();

    	// Creating n players 
        for (int i = 0; i < number_deck; i++){
            this.players.add(new Player());
        }
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
    		
    		// Dealer ask to each player (for homework2 there is only one player
    		while (dealer.askHitOrStand(players.get(0))){
    			System.out.println("Your action: " + players.get(0).getAction());
        	}
    		System.out.println("Your action: " + players.get(0).getAction());
        		
			System.out.println(Main.verbose ? players.get(0).getName() + " choosed " + players.get(0).getAction(): "" );

			// numeros de rondas para HW1 
    		countround++;
    	}

    }
    
    public static void tableView(Dealer dealer, ArrayList<Player> players) {
    	System.out.println("\n*** Table view***");
    	
    	// Print dealers hand
    	System.out.println("Dealer has: " + dealer.getCards().toString() + " [Score: "+dealer.score()+"].");
    	
    	// Print Players hands
		for (Player player : players) { 		      
	           System.out.println("Player *" + player.getName() + "* has: " + player.getCards() + " [Score: "+player.score()+"]."); 	
	           player.score();
	      }
    }
}
