package Objects;

import java.util.ArrayList;

import java.util.Dictionary;
import java.util.Hashtable;

public class Hand {
	private boolean bust = false;
	private ArrayList<Card> cards = new ArrayList<Card>();
	private Dictionary<String, Integer> dict= new Hashtable<String, Integer>();
	

	public Hand() {
	    dict.put("2", 2);
	    
	    
	    
	    dict.put("2", 2);
	    dict.put("J", 10);
	    dict.put("A", 11);
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
		int score = 0;
		// Imprimiento array de jugadores
		for (Card card : this.cards) { 		      
	           //score += this.dict.get(card.getId());
			System.out.println(this.dict.get(card.getId()));
	      }
		return 77;
	}
}
