
public class Player {
	private String name;
	private int wins = 0;
	private int losses = 0;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWins() {
		return wins;
	}
	//Adds to wins
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	public void addWins(int wins) {
		this.wins += wins;
	}
	
	public int getLosses() {
		return losses;
	}
	//Adds to losses
	public void addLosses(int losses) {
		this.losses += losses;
	}
	
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	public String toString() {
		return "Player [name=" + name + ", wins=" + wins + 
				", losses=" + losses + "]";
	}
	
	
}
