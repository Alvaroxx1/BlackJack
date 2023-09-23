package Objects;

import java.util.ArrayList;

public class Deck {
	private String[] index = {"2","3","4","5","6","7",
			"8","9","T","J","Q","K","A"};
	private String[] suits = {"d","c","h","s"};
	
	private ArrayList<Card> cards;
	
	public Deck() {
		
		Card mycard = new Card("4h");
		System.out.println(mycard.toString());
		
		for(int n = 0;n<=3;n++) {
			for(int i = 2; i<10;i++) {
				this.cards.add(new Card(i+index[n]));
				
			}
		}
		
	}
	
	
}
