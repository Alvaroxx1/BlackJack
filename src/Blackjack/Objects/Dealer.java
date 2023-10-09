package Objects;

import Blackjack.Main;

import java.util.Random;

public class Dealer extends Hand {
	private String name = "";

	public Dealer() {
		this.name = "DEALER";
		
	}
	
	public void cardToPlayer(Player player, Deck deck) {
		Card c = deck.popCard();
		player.add(c);
		System.out.println("Card dealt to *" + player.getName() + "* is : " + c.toString() + " [Score: "+player.score()+"].");
	}
	
	public void cardToDealer(Deck deck) {
		Card c = deck.popCard();
		this.add(c);
		//this.add(new Card("Ah"));
		System.out.println("Card dealt to *" + this.name + "* is : " + c.toString() + " [Score: "+ this.score() +"].");
	}

	public boolean askHitOrStand(Player player) {
		System.out.println("*** Choose your action ***");
		System.out.println("***    [hit, stand]    ***");
		player.setAction(Main.scannerObjectString());
		return player.isStand();	
	}
}
