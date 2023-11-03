package Blackjack;
import java.util.ArrayList;

import Objects.Dealer;
import Objects.Deck;
import Objects.Player;

public class Game {
    Dealer dealer = new Dealer();
    // Declare the deck card
    Deck deck;
    
    ArrayList<Player> players = new ArrayList<Player>();
    
	// Constructor
    public Game(int number_players, int number_deck){    
		Main.CLS();	
		// press Enter to start the game
    	System.out.println("\n************************************************");		
        System.out.println("*** The game is starting...***");
    	System.out.println("\n************************************************");		

		// // Disabled - fasting testing
		// Main.scannerObjectString();

    	// Creating n players 
		String name;
        for (int i = 0; i < number_players; i++){
			System.out.print("Player" + (i + 1) + " name: ");

			name = Main.scannerObjectString();
			// name = scannerObjectString();
            this.players.add(new Player(name, 10));
        }
        // Initilize the number of Decks
        deck = new Deck(number_deck);
    }	


    // only one round for this hw1
    public void rounds(int rounds) {
    	int countround = 0;
    	while (countround < rounds){

    	System.out.println("\n************************************************");		
        System.out.println("*** Round number: " + (countround + 1) + " ***");
        System.out.println("*** cards left in deck: " + this.deck.countCards() + " ***");
    	System.out.println("\n************************************************");		
		Main.wait(2000);	
			// dealer give cards to each player
			for (Player player : players) { 		      
				dealer.cardToPlayer(player, this.deck);
				Main.wait(1500);	
		   }

    		// dealer give card to dealer
    		dealer.cardToDealer(this.deck);
			Main.wait(1500);	
   
			// give a space to second group of card given by Dealer
			System.out.println("");

			// dealer give cards to each player
			for (Player player : players) { 		      
				dealer.cardToPlayer(player, this.deck);
				Main.wait(1500);	
		   }
    		
			// dealer give a HIDDEN card to dealer
    		dealer.cardToDealer(this.deck, true);
			Main.wait(3000);	
			
			// clear screen
			Main.CLS();
    		// Table view
    		tableView(this.dealer, this.players);
    		
			// Dealer interact with each player 
			for (Player player : players) { 		      
				System.out.println("Player " + player.getName() + " turn:");
				System.out.println("Press enter to reveal your cards.");
    			System.out.println("\n************************************************");		
				Main.scannerObjectString();

				// revealing player cards
				System.out.println(player.getCards());
				// Dealer ask to current player (for homework2 there is only one player
				while (dealer.askHitOrStand(player) &&  !(player.score() > 21) && !(dealer.score() > 21)){
					System.out.println(player.getName() +" action is: " + player.getAction());

					// If player choose to hit, dealer give him another card
					if (player.isStand())
							dealer.cardToPlayer(player, this.deck);
				}
				System.out.println(player.getName() + " action is: " + player.getAction());

        		
				System.out.println(Main.verbose ? player.getName() + " choosed " + player.getAction(): "" );
			}

			// Reveal hidden card
			dealer.revealHiddenCard();

			// Second Table view checking revealing card
			tableView(this.dealer, this.players);

			// # check round score and winner.
			// roundScores(this.dealer, this.players);

			System.out.println("check");

			// Clear all hands
			this.dealer.dropAllCards();
			// this.players.get(0).dropAllCards();

			//Restar
			// numeros de rondas para HW1 
    		countround++;
    	}

    }
    
    public static void tableView(Dealer dealer, ArrayList<Player> players) {
    	System.out.println("\n************************************************");		
    	System.out.println("*** Table view***");
    	
    	// Print dealers hand
    	System.out.println("Dealer has: " + dealer.getCards() + dealer.countHiddenCards() + " [Score: "+dealer.score()+"].");
		// System.out.println("Dealer Hidden card: " + dealer.getHiddenCards().toString());
    	// Print Players hands
		for (Player player : players) { 		      
	           System.out.println("Player *" + player.getName() + "* has: " + player.getCards() + " [Score: "+player.score()+"]."); 	
	           player.score();
	      }
    	System.out.println("\n************************************************");		
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
