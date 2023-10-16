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
    		
			// dealer give a HIDDEN card to dealer
    		dealer.cardToDealer(this.deck, true);
			
    		// Table view
    		tableView(this.dealer, this.players);
    		
    		// Dealer ask to each player (for homework2 there is only one player
    		while (dealer.askHitOrStand(players.get(0))){
    			System.out.println("Your action: " + players.get(0).getAction());

				// If player choose to hit, dealer give him another card
				if (players.get(0).isStand())
						dealer.cardToPlayer(players.get(0), this.deck);
        	}
    		System.out.println("Your action: " + players.get(0).getAction());

        		
			System.out.println(Main.verbose ? players.get(0).getName() + " choosed " + players.get(0).getAction(): "" );

			// Reveal hidden card
			dealer.revealHiddenCard();

			// Second Table view checking revealing card
			tableView(this.dealer, this.players);

			// # check round score and winner.
			roundScores(this.dealer, this.players);
			// numeros de rondas para HW1 
    		countround++;
    	}

    }
    
    public static void tableView(Dealer dealer, ArrayList<Player> players) {
    	System.out.println("*** Table view***");
    	
    	// Print dealers hand
    	System.out.println("Dealer has: " + dealer.getCards() + dealer.countHiddenCards() + " [Score: "+dealer.score()+"].");
		// System.out.println("Dealer Hidden card: " + dealer.getHiddenCards().toString());
    	// Print Players hands
		for (Player player : players) { 		      
	           System.out.println("Player *" + player.getName() + "* has: " + player.getCards() + " [Score: "+player.score()+"]."); 	
	           player.score();
	      }
    }

    public static void roundScores(Dealer dealer, ArrayList<Player> players) {
    	System.out.println("\n***********************************");
		// Print dealer Score
		System.out.println(dealer.getName() + "'s score: " + dealer.score());
		System.out.println(players.get(0).getName() + "'s score: " + players.get(0).score());

		if (players.get(0).score() > dealer.score() &&  !(players.get(0).score() > 21) && !(dealer.score() > 21))
			System.out.println(players.get(0).getName() +  " win.");
		else
			System.out.println(players.get(0).getName() +  " loses.");
	}
}
