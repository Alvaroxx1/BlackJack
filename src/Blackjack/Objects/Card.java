package Objects;


public class Card {
	//private ArrayList<String> index;
	private String value;
	private String suit;
	
	
	public Card(String value,String suit) {
		this.value = value;
		this.suit = suit;
		
	}
	
	public String getId() {
		return this.value;
	}
	
	public String getSuit() {
		return this.suit;
	}
	// Print card
	@Override
	public String toString() {
		return this.value+this.suit;
	}

}
