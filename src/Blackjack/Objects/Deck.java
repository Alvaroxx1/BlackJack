package Objects;
import java.util.Random;
import test.*;
import java.util.ArrayList;

public class Deck {
	private String[] index = {"T","J","Q","K","A"};
	private String[] suits = {"d","c","h","s"};
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	Random random = new Random();
	// Constructor
	public Deck() {
		

		//Card mycard = new Card("4h");
		//System.out.println(mycard.toString());
		
		for(int n = 0;n<=3;n++) 
		{
			// From 2 to 9
			for(int i = 2; i<10;i++) 
			{
				this.cards.add(new Card(i+suits[n]));	
			}
			// Special cards
			for (int j=0 ; j<5; j++) 
			{
				this.cards.add(new Card(index[j]+suits[n]));
			}
		}
	}
	
	
	public void display() {
		for (Card card : this.cards) { 		      
	           System.out.println(card); 		
	      }
	}
	
	public Card popCard() {
		int randNum = random.nextInt(32);
		
		while (cards.equals(randNum)&&randNum ==0) {
			randNum = random.nextInt(32);
		}
		
		return this.cards.remove(randNum);
	}
	
	public int countCards() {
		return this.cards.size();
	}
}
