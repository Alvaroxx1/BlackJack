package Objects;

import java.util.ArrayList;

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
		System.out.println("Card dealt to *" + player.getName() + "* is : " + c.toString() + " [Score: "+c.getId()+"].");
	}
	
	public void cardToDealer(Deck deck) {
		Card c = deck.popCard();
		this.add(c);
		//this.add(new Card("Ah"));
		System.out.println("Card dealt to *" + this.name + "* is : " + c.toString() + " [Score: "+ this.score() +"].");
	}
	
	// overload function to handle hidden cards
	public void cardToDealer(Deck deck, boolean hidden) {
		Card c = deck.popCard();
		this.addHidden(c);
		//this.add(new Card("Ah"));
		System.out.println("Card dealt to *" + this.name + "* is : " + "Xx" + " [Score: "+ "X" +"].\n");
	}

	public void addHidden (Card card) {
		this.hiddencards.add(card);
	}

	public void revealHiddenCard(){
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
		System.out.println("*** Choose your action ***");
		System.out.println("***    [hit, stand]    ***");
		player.setAction(Main.scannerObjectString());
		return player.isStand();	
	}


}
