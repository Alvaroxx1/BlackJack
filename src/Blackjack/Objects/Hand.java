package Objects;

import java.util.ArrayList;

public class Hand {
	private boolean bust = false;
	private ArrayList<Card> cards = new ArrayList<Card>();
	

	public Hand() {
		
	}
	
	public void add(Card card) {
		this.cards.add(card);
	}
	
	public ArrayList<Card> getCards() {
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
	
	public int score() {
		int score=0;
		// Imprimiento array de jugadores
		for (Card card : this.cards) { 		      
	           score += Integer.parseInt(card.getId()) ; 		
	      }
		return score;
	}
}
