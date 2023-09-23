package Blackjack;

import Objects.*;
import java.util.ArrayList;

public class Game {

    Dealer dealer = new Dealer();
    Deck deck = new Deck();
    ArrayList<Player> players = new ArrayList<Player>();
    
	// Constructor
    public Game(int number_players, int number_deck){    	
    	// Creating n players 
        for (int i = 0; i < number_deck; i++){
            this.players.add(new Player());
        }
    }	

    public void presStart(){
        System.out.println("Press enter to start.(skipped)"); 
    }
    
    public void round() {
    	int countround = 0;
    	while (countround < this.deck.countCards()){
    		System.out.print(dealer.cardToAir(this.deck).toString() + ", ");
    		countround++;
    	}
    }
}
