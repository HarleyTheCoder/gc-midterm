import java.text.DecimalFormat;

//Store guesses and word lengths
//Use methods to calculate their averages

public class Player {
	private String name;
	private int wins = 0;
	private int losses = 0;
	private String guessNums = "-1"; //This is used to calculate average guesses
	private String wordLengths = "-1"; //Used to calculate average word length
	
	public Player(String name) { //Only need to set name, the rest get set by default
		this.name = name;
	}
	
	//Calculate percentage of wins, return as string
	public String calcWinPercent() {
		DecimalFormat percentFormat = new DecimalFormat("#.0%");
		double totalPlays = wins + losses;
		String percentWins = "";
		if (wins == 0) {
			percentWins = percentFormat.format(0);
		} else {
			percentWins = percentFormat.format(wins / totalPlays);
		}
		return percentWins;
		
	}
	
	//get win percent as double
	public double getWinPercent() {
		String sPercent = calcWinPercent();
		sPercent = sPercent.replace("%", "");
		try {
			Double dPercent = Double.parseDouble(sPercent);
			return dPercent;
		} catch (Exception e) {
			return -1;
		}
	}
	
	//Calculate average number of guesses to win, return as string
	public String calcAvgGuesses() {
		DecimalFormat avgFormat = new DecimalFormat("###.0");
		String[] guesses = guessNums.split("~");
		String avgGuesses = "";
		int howMany = guesses.length;
		double total = 0;
		if (guesses[0].equals("-1")) { //returns -1 if there's not enough data to calculate
			return "n/a";
		} else {
			for (String guess: guesses) {
				total += Double.parseDouble(guess);
			}
			avgGuesses = avgFormat.format(total / howMany);
			return avgGuesses;
		}
	}
	
	//Get average guesses as double
	public double getAvgGuesses() {
		String sAverage = calcAvgGuesses();
		try {
			Double dAverage = Double.parseDouble(sAverage);
			return dAverage;
		} catch (Exception e) {
			return -1;
		}
	}
	
	//Calculate average word length, return as string
	public String calcAvgLength() {
		DecimalFormat avgFormat = new DecimalFormat("###.0");
		String[] lengths = wordLengths.split("~");
		String avgWordLength = "";
		double howMany = lengths.length;
		double total = 0;
		if (lengths[0].equals("-1")) {
			return "n/a"; //returns -1 if there's not enough data to calculate
		} else {
			for (String length: lengths) {
				total += Double.parseDouble(length);
			}
			avgWordLength = avgFormat.format(total / howMany);
			return avgWordLength;
		}
	}
	
	//Get average word length as a double
	public double getAvgLength() {
		String sAverage = calcAvgLength();
		try {
			Double dAverage = Double.parseDouble(sAverage);
			return dAverage;
		} catch (Exception e) {
			return -1;
		}
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
	
	//Keep track of game guesses and word lengths
	//to calculate averages with
	public String getGuessNums() {
		return guessNums;
	}

	public void setGuessNums(String guessNums) {
		
		this.guessNums = guessNums;
	}
	
	//Add
	public void addGuessNums(String guessNum) {
		if (guessNums.equals("-1")) {
			guessNums = "" + guessNum;
		} else {
			guessNums += "~" + guessNum;
		}
	}

	public String getWordLengths() {
		return wordLengths;
	}

	public void setWordLengths(String wordLengths) {
		this.wordLengths = wordLengths;
	}
	
	//Add to list of lengths
	public void addWordLengths(String wordLength) {
		if (wordLengths.equals("-1")) {
			wordLengths = "" + wordLength;
		} else {
			wordLengths += "~" + wordLength;
		}
	}
	
	
	//Update this
	public String toString() {
		return "Player [name=" + name + ", wins=" + wins + 
				", losses=" + losses + ", win %=" + calcWinPercent() +
				", avg guesses=" + calcAvgGuesses() + ", avg word length=" + 
				calcAvgLength() +  "]";
	}
	
	
}
