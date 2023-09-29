package Objects;


public class Card {
	//private ArrayList<String> index;
	private String value; //2, 3, 4, 5, 6, 7, 8, 9, J, Q, K, A
	private String suit;
	
	
	public Card(String value) {
		String[] parts = value.split("");
		
		this.value = parts[0];
		this.suit = parts[1];
		
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
