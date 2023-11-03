package Objects;

public class Player extends Hand {

	private String name;
	private int balance;
	
	// Contructores
	public Player(String name, int value) {
        this.name = name;
        this.balance = value;
    }
	// sobrecarga del constructor
	public Player() {
		
        // # a ths pevel it is set to a only one player name
        // System.out.println("Enter name:");
        // String name = scannerObjet.nextLine();
		
        this.name = "Vaidas";
  
        // # at this level te balance is setted by default
        //System.out.println("Set balance.");

		this.balance = 10;

	}
	
	// ## Funciones de la clase
	// Setter y getters
	public void setName(String name) {
		this.name = name;
	}
    public String getName() {
        return this.name;
    }
    
    public void setBalance(int value) {
    	this.balance = value;
    }
    
    public int getBalance() {
    	return this.balance;
    }
    
    public int updateBalance(int value){
        this.balance += value;
        return this.balance;
    }
    // toString()
    public String toString() {
    	return "[Name: " + this.name + ",  Balance: " + this.balance +"]";
    }

}
