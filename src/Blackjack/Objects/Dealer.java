package Objects;

import java.util.Scanner;

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

	public void askHitOrStand(Player player) {
		System.out.println("*** Choose your action ***");
		System.out.println("***    [hit, stand]    ***");
		
		Scanner xx = new Scanner(System.in);
		String chooseAction = xx.nextLine();
		
		//System.out.println(" is there a next? " + IN.hasNext());
		System.out.println("The choosen value is: " + chooseAction);
		
		
	//String chooseAction = "hit"
	//String chooseAction = "stand";

		
		player.setAction(chooseAction);
		System.out.println("Your action: " + player.getAction());
		
		xx.close();
	}

}
