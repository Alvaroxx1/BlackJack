package Objects;

public class Player {

	private String name;
	private int balance;
	
	// Contructores
	public Player(String name, int value) {
        this.name = name;
        this.balance = value;
    }
	// sobrecarga del constructor
//	public Player() {
//		this.name = setName();
//		this.name = setBalance();
//	}
	
	// ## Funciones de la clase
	// Setter y getters
	private void setName(String name) {
		this.name = name;
	}
    private String getName() {
        return this.name;
    }
    
    private void setBalance(int value) {
    	this.balance = value;
    }
    
    public int getBalance(int value) {
    	return this.balance;
    }
    
    // toString()
    public String toString() {
    	return "[Name: " + this.name + ",  Balance: " + this.balance +"]";
    }
}
