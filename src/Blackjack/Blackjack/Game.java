package Blackjack;
import java.util.ArrayList;

import Menu.Welcome;
import Objects.Dealer;
import Objects.Deck;
import Objects.Player;

public class Game {
    Dealer dealer = new Dealer();
    // Declare the deck card
    Deck deck;
    
    ArrayList<Player> players = new ArrayList<Player>();
    ArrayList<Player> leftplayers = new ArrayList<Player>();
    
    //Centinel Variable
    Boolean check = true;
    
	int delayTime = 500;
    
	// Constructor
    public Game(int number_players, int number_deck){ 
		
		int DEFAULT_BALANCE = 3;

		Main.CLS();	
		Welcome.printWelcome();
		// press Enter to start the game
    	System.out.println("\n************************************************");		
        System.out.println("*** The game is starting...***");
    	System.out.println("\n************************************************");		

		// ! here need a 1-3 player error handler
		System.out.println("How many player will play [1-3]: ");
		
		while (check) {
		    try {
		        number_players = Integer.valueOf(Main.scannerObjectString());
		        // If the user entered a number, the code will reach here
		        check = false; // Exit the loop since a valid number is entered
		    } catch (NumberFormatException e) {
		        // If the user did not enter a number, the code will reach here
		        System.out.println("Please enter a valid number.");
		        // Optionally, you can add more instructions or prompt the user again
		        check = true;
		    }
		}


		

		// System.out.println(number_players);

    	// Creating n players 
		String name;
        for (int i = 0; i < number_players; i++){
			System.out.print("Player" + (i + 1) + " name: ");

			name = Main.scannerObjectString();
			// name = scannerObjectString();
            this.players.add(new Player(name, DEFAULT_BALANCE));
        }
        // Initilize the number of Decks
        deck = new Deck(number_deck);

		System.out.println("\nPress enter to start.");
		Main.scannerObjectString();

		this.rounds(players, leftplayers); // max number of round on this game.

    }	


    // only one round for this hw1
    public int rounds(ArrayList<Player> players, ArrayList<Player> leftPlayers) {
    	int countround = 0;
		// To handle to continue the round or not
		String Round_Action = "";
		Player movingPlayer = null;

    	while (countround >= 0 && !players.isEmpty()){

			Main.CLS();
			Welcome.printWelcome();

			// Pay bet to join this round.
			System.out.println("\n************************************************");		
			System.out.println("*** Paying $1 Bet to join this round ***");
			payBet(this.players, this.leftplayers);

			// players who left the table
			tableLeftPlayers(this.leftplayers);

			// Check is there are players in the table
			if(players.isEmpty()){
				
				System.out.println("no more players in the table");
				System.out.println("Press enter to exit...");
				Main.scannerObjectString();
				break;
			}

			System.out.println
			
			
			("\n************************************************");		
			System.out.println("*** Round number: " + (countround + 1) + " ***");
			System.out.println("*** cards left in deck: " + this.deck.countCards() + " ***");
			System.out.println("************************************************");		
    		System.out.println("*** Dealing cards ***");
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
					else System.out.println("\nYou continue playing in this round.");
					
					System.out.println("***Choose you action to continue the game***\n"
							+ "			*** [continue, end]    ***");
					Round_Action = Main.scannerObjectString();

					if(Round_Action.equals("end")){
						movingPlayer = players.remove(players.indexOf(player));
						leftPlayers.add(movingPlayer);
					}

				}
				// System.out.println(player.getName() + " action is: " + player.getAction()); // Resquired on homework originally.

        		
				System.out.println(Main.verbose ? player.getName() + " choosed " + player.getAction(): "" );
    
				System.out.println("\n\nPress enter to next player continue...");
				Main.scannerObjectString();
			}

			// Reveal hidden card
			dealer.revealHiddenCard();

			// Second Table view checking revealing card
			tableView(this.dealer, this.players, true);

			// # check round score and winner.
			roundScores(this.dealer, this.players);

			// show updated players balances
			tableBalances(this.players);

			// Clear all hands
			this.dealer.dropAllCards();
			for (Player player : players) player.dropAllCards();
			// this.players.get(0).dropAllCards();

			//Restar
			// numeros de rondas para HW1 
    		countround++;

			System.out.println("\n\n>> Press enter to go to next round...");
			System.out.println("\n************************************************");		
			Main.scannerObjectString();
    	}
		Main.CLS();
		Menu.Welcome.printWelcome();
		Main.wait(3000);
		System.out.println(" ... so  sad...");
		System.out.println("\n\n");
		Main.wait(3000);
		Menu.GameOver.printGameOver();
		Main.wait(3000);
		return 0;
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
		System.out.println("*** FINAL ROUND SCORES ***");
		// Print dealer Score
		// System.out.println(dealer.getName() + "'s score: " + dealer.score());
		
		// Show Dealer Score
		System.out.println("- " + dealer.getName() + " [Score: " + dealer.score() + "].");

		// Check each player score
		// Busted and Loss is zero because we already substract one coin in the 
		// beginning of the round
		for (Player player : players){

			System.out.println("\n- " + player.getName() + " [Score: " + player.score() + "] ");
			if (player.isBust()){
				System.out.print("╚══> BUSTED, loosing -1 bet.\n");
				player.updateBalance(0);
			}
			else
				if (player.score() > dealer.score()){
					System.out.print("╚══> WIN: getting 2 bets.\n");
					player.updateBalance(2);
				}
				else if (player.score() == dealer.score()){
					System.out.print("╚══> DRAW: Taking 1 bet back.\n ");
					player.updateBalance(1);
				}
				else{
					System.out.print("╚══> LOSS: loosing -1 bet.\n ");
					player.updateBalance(0);
				}

		}
	}

	public static void tableBalances(ArrayList<Player> players){
    	System.out.println("\n************************************************");		
		System.out.println("*** PLAYERS BALANCES UPDATED ***");
		for (Player player : players){
			System.out.println("\n- " + player.getName() + " [Balance: " + player.getBalance() + "] ");
		}
	}

	public static int payBet(ArrayList<Player> players, ArrayList<Player> leftPlayers){
		Player movingPlayer = null;
		for (Player player : players){
			//payment to enter the round
			if (player.getBalance() >= 1){
				player.updateBalance(-1);
				System.out.println("- " + player.getName() + " Bet $1.");
			}
			else {
				System.out.println(player.getName() + " left the table.");
				// System.out.println("Reason: Blance cero.");
				// System.out.println("el que pierde esta en index: " + players.indexOf(player));
				// leftPlayers.add(players.remove(players.indexOf(player)));
				
				// if (!players.isEmpty())
				movingPlayer = players.remove(players.indexOf(player));
				leftPlayers.add(movingPlayer);

				// System.out.println(leftPlayers);
				// System.out.println(players);
				payBet(players, leftPlayers);
				return 0;
			}
		}
		return 0;

	}

	public static void tableLeftPlayers(ArrayList<Player> leftPlayers){
		if (!leftPlayers.isEmpty()){
			System.out.println("\n************************************************");		
			System.out.println("*** LEFT PLAYERS ***");
			for (Player leftplayer : leftPlayers){
				System.out.println("\n- " + leftplayer.getName()) ;
			} 
		}
	}
}
