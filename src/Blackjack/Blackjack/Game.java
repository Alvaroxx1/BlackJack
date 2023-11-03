package Blackjack;
import java.util.ArrayList;

import Objects.Dealer;
import Objects.Deck;
import Objects.Player;
import Menu.Welcome;

public class Game {
    Dealer dealer = new Dealer();
    // Declare the deck card
    Deck deck;
    
    ArrayList<Player> players = new ArrayList<Player>();
	int delayTime = 500;
    
	// Constructor
    public Game(int number_players, int number_deck){    
		Main.CLS();	
		Welcome.printWelcome();
		// press Enter to start the game
    	System.out.println("\n************************************************");		
        System.out.println("*** The game is starting...***");
    	System.out.println("\n************************************************");		

		// ! here need a 1-3 player error handler
		System.out.println("How many player will play [1-3]: ");
		number_players = Integer.valueOf(Main.scannerObjectString());

		// System.out.println(number_players);

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

		System.out.println("\nPress enter to start.");
		Main.scannerObjectString();
    }	


    // only one round for this hw1
    public void rounds(int rounds) {
    	int countround = 0;
    	while (countround < rounds){

			Main.CLS();
			Welcome.printWelcome();
			System.out.println("\n************************************************");		
			System.out.println("*** Round number: " + (countround + 1) + " ***");
			System.out.println("*** cards left in deck: " + this.deck.countCards() + " ***");
			System.out.println("\n************************************************");		
			Main.wait(delayTime);	
			// dealer give cards to each player
			for (Player player : players) { 		      
				dealer.cardToPlayer(player, this.deck);
				Main.wait(delayTime);	
		   }

    		// dealer give card to dealer
    		dealer.cardToDealer(this.deck);
			Main.wait(delayTime);	
   
			// give a space to second group of card given by Dealer
			System.out.println("");

			// dealer give cards to each player
			for (Player player : players) { 		      
				dealer.cardToPlayer(player, this.deck);
				Main.wait(delayTime);	
		   }
    		
			// dealer give a HIDDEN card to dealer
    		dealer.cardToDealer(this.deck, true);
			
			// // Here could wait 3 second to next screen or, press enter to continue
			// Main.wait(3000);	
			System.out.println("Press to continue...");
			Main.scannerObjectString();
			
    		
			// Dealer interact with each player 
			for (Player player : players) { 		      
				// clear screen
				Main.CLS();
				Menu.Welcome.printWelcome();
				// Table view
				tableView(this.dealer, this.players, true);
    			System.out.println("\n************************************************");		
				System.out.println("Player " + Main.fixedLengthString(player.getName(), 10) + " turn:");
				System.out.println("Your cards are: " + player.getCards() + " [Score: " + player.score() + "]");
				// System.out.println("Press enter to reveal your cards.");
    			System.out.println("************************************************");		
				// Main.scannerObjectString();

				// revealing player cards
				// System.out.println(player.getCards());

				// Dealer ask to current player (for homework2 there is only one player, for miniproject added nplayers
				while (!player.isBust() && dealer.askHitOrStand(player)) {
					System.out.println(player.getName() +" action is: " + player.getAction());

					// check message value
					// System.out.println(("Is this hand's player busted?: " + player.isBust()));
					// System.out.println(("Currend hand score: " + player.score()));

					// If player choose to hit, dealer give him another card
					if (player.isStand())
							dealer.cardToPlayer(player, this.deck);

					// Print message if got bust
					// System.out.println(("Is this hand's player busted after receiving a card?: " + player.isBust()));
					// System.out.println(("Currend hand score: " + player.score()));

					if (player.isBust()) System.out.println("You got Busted!");
					else System.out.println("You continue plying in this round.");
				}
				// System.out.println(player.getName() + " action is: " + player.getAction()); // Resquired on homework originally.

        		
				System.out.println(Main.verbose ? player.getName() + " choosed " + player.getAction(): "" );
    
				System.out.println("Press enter to next player continue...");
				Main.scannerObjectString();
			}

			// Reveal hidden card
			dealer.revealHiddenCard();

			// Second Table view checking revealing card
			tableView(this.dealer, this.players, true);

			// # check round score and winner.
			roundScores(this.dealer, this.players);

			// Clear all hands
			this.dealer.dropAllCards();
			// this.players.get(0).dropAllCards();

			//Restar
			// numeros de rondas para HW1 
    		countround++;

				System.out.println("Press enter to go to next round...");
    			System.out.println("\n************************************************");		
				Main.scannerObjectString();
    	}

    }
    
    public static void tableView(Dealer dealer, ArrayList<Player> players, boolean showPlayers) {
		if (!showPlayers) Welcome.printWelcome();
    	System.out.println("\n************************************************");		
    	System.out.println("*** Table view***");
    	
		// Print Players hands
		if (showPlayers) {
			for (Player player : players) { 		      
				System.out.println("Player *" + Main.fixedLengthString(player.getName(), 10) + "* has: " + player.getCards()
				+ " [Score: " + player.score()+"]"
				+ " [Balance: " + player.getBalance() + "]."
				+ " [Status: " + (player.isBust() ? "BUSTED!." : "- ") + "]."); 	
			}
   		 }

    	// Print dealers hand
    	System.out.println("          Dealer has: " + dealer.getCards() + dealer.countHiddenCards() + " [Score: "+dealer.score()+"].");
		// System.out.println("Dealer Hidden card: " + dealer.getHiddenCards().toString());
		System.out.println("\n************************************************");		
	}

    public static void roundScores(Dealer dealer, ArrayList<Player> players) {
		// Print dealer Score
		// System.out.println(dealer.getName() + "'s score: " + dealer.score());
		
		// Show Dealer Score
		System.out.println(dealer.getName() + " - " + dealer.score());

		// Check each player score
		for (Player player : players){

			System.out.println(player.getName() + " - " + player.score());
			if (player.isBust()){
				System.out.println("Player is busted, loosing -1 bet.");
				player.updateBalance(-1);
			}
			else
				if (player.score() > dealer.score()){
					System.out.println("WIN: getting 2 bets.");
					player.updateBalance(2);
				}
				else{
					System.out.println("DRAW: Taking 1 bet back.");
					player.updateBalance(1);
				}


			// if (players.get(0).score() > dealer.score() &&  !(players.get(0).score() > 21) && !(dealer.score() > 21))
				// System.out.println(players.get(0).getName() +  " win.");
			// else
				// System.out.println(players.get(0).getName() +  " loses.");
		}
	}
}
