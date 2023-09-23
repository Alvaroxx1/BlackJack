package Objects;

import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private boolean bust = false;
	

	public Hand() {
		
	}
	
	public void add(Card card) {
		this.cards.add(card);
	}
	
	public ArrayList getCards() {
		return this.cards;
	}
	
	public String toString() {
		String cardsString = "";
		
		for (Card card : this.cards) { 		      
	           cardsString += card.toString(); 		
	      }
		return cardsString;
	}

	public void clean() {
		this.cards.clear();
	}
}
