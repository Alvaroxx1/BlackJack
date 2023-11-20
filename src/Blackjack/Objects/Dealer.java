package Objects;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import Blackjack.Main;

public class Dealer extends Hand {
	private String name = "";
	private ArrayList<Card> hiddencards = new ArrayList<Card>();

	public Dealer() {
		this.name = "DEALER";
		
	}

	public String getName(){
		return this.name;
	}
	
	public void cardToPlayer(Player player, Deck deck) {
		Card c = deck.popCard();
		player.add(c);
		System.out.println("Card dealt to *" + Main.fixedLengthString(player.getName(), 10) + "   *\t is : " + c.toString() + " [Score: "+c.getId()+"]" + " [Balance: " + player.getBalance() + "] " + "[Bet: " + Main.fixedLengthString(Integer.toString(player.getBet()), 3) + "].");
	}
	
	public void cardToDealer(Deck deck) {
		Card c = deck.popCard();
		this.add(c);
		//this.add(new Card("Ah"));
		System.out.println("Card dealt to *" + Main.fixedLengthString(this.name, 10) + "   *\t is : " + c.toString() + " [Score: "+ this.score() +"].");
	}
	
	// overload function to handle hidden cards
	public void cardToDealer(Deck deck, boolean hidden) {
		Card c = deck.popCard();
		this.addHidden(c);
		//this.add(new Card("Ah"));
		System.out.println("Card dealt to *" + Main.fixedLengthString(this.name, 10) + "   *\t is : " + "Xx" + " [Score: "+ "X" +"].\n");
	}

	public void addHidden (Card card) {
		this.hiddencards.add(card);
	}

	public void revealHiddenCard(){
		Main.CLS();
		Menu.Welcome.printWelcome();
		Card c = this.hiddencards.remove(0);
		System.out.println("************************************************");
		System.out.println("Show " + this.name + "'s second card is: " + c.toString() + " [Score: " + c.getId() + "]");
		System.out.println("************************************************");
		this.add(c);
	}

	public ArrayList<Card> getHiddenCards(){
		return this.hiddencards;
	}

	public String countHiddenCards(){
		if (this.hiddencards.size() > 0)
			return " [Xx]";
		else
			return "";
	}

	public boolean askHitOrStand(Player player) {
		System.out.println("");
		System.out.println(">>> Choose your action <<<");
		System.out.println(">>>    [hit, stand]    <<<");
		System.out.println();
		
		// // Disabled manual input for testing.
		// // auto choosing is 50% hit, 50% stand
		// String [] playerchoises = {"hit", "stand"}; // for automatization
		// Main.wait(1000);	
		// player.setAction(playerchoises[new Random().nextInt(playerchoises.length)]);
		
		// Enabled manual input for hit and stand.
		player.setAction(Main.scannerObjectString());
		
		return player.isStand();	
	}


}
