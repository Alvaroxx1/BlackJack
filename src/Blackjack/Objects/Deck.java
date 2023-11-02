package Objects;
import java.util.Random;
import test.*;
import java.util.ArrayList;

public class Deck {
	private String[] index = {"T","J","Q","K","A"};
	private String[] suits = {"d","c","h","s"};
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	private ArrayList<Card> temp = new ArrayList<Card>();
	
	Random random = new Random();
	
	// Constructor
	public Deck(int numDecks) {
		//Number of Decks for loop
		for(int decks=0; decks < numDecks; decks++) 
		{
			// Creating all card combinations
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
		shuffle();
	}
	
	// Implementation to get random cards
	
	public void shuffle() {
	    // Fisher-Yates shuffle for the 'cards' array
	    for (int i = cards.size() - 1; i > 0; i--) {
	        int j = random.nextInt(i + 1);
	        Card tempCard = cards.get(i);
	        cards.set(i, cards.get(j));
	        cards.set(j, tempCard);
	    }
	}
	public void display() {
		for (Card card : this.cards) { 		      
	           System.out.println(card); 		
	      }
	}
	
	public Card popCard() {
		return this.cards.remove(0); // this will throw exception when no more cards in deck
	}
	
	public int countCards() {
		return this.cards.size();
	}
	
	// Function to return the cards back to the deck
	
    public void shuffleTempIntoMainDeck() {
        // Check if the main deck has 10 cards or fewer
        if (this.cards.size() <= 10) {
            // Shuffle the cards in the temporary array back into the main deck
            this.cards.addAll(temp);
            temp.clear(); // Clear the temporary array
        }
        // shuffle all the cards after retrieving again
        shuffle();
    }
}
