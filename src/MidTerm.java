import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MidTerm {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//Wins and losses variables
		int wins = 0;
		int losses = 0;
		String name = "";
		
		final int MISSES_ALLOWED = 6;
		int misses = 0; //might be temporary
		String guess = ""; //might be temp
		String wordToSolve;
		List<String> words = new ArrayList<>();
		List<String> blankWord = new ArrayList<>(); //This is for the display

		
		
		//Set path for the words text file
		String dirPath = "src/";
		Path path = Paths.get(dirPath + "HangManWords.txt");
		
		//Store words from text file into the list
		Game.storeWords(path, words);
		boolean goAgain = true;
		while (goAgain) { //While loop for a new game. Goes until user quits.
			
			wordToSolve = Game.selectWord(words); //Pick a word for the game
			Game.createEmptyWord(wordToSolve, blankWord); //Create empty display
															//of the word.
			
			//TEST CODE - TEMPORARY
			//test - delete later
			
			//Show new round until player misses too many times
			while (misses < MISSES_ALLOWED) {
				misses = Game.nextRound(blankWord, wordToSolve, misses, scan);
				if (misses == 6) {
					System.out.println(HangedMan.gameOver());
					losses += 1;
				} 
				
			
			
			
			//Area to test high score code
			//Keep separate
			List <Player> players = new ArrayList<>();
			Path playerPath = Paths.get(dirPath + "Players.txt");
			
			//Load existing players in a list
			Game.setPlayers(playerPath, players);
			
			//Get user name,
			System.out.print("\nEnter a user name for the high score table: ");
			name = Validator.getString(scan);
			
			//Check if name exists, if not create new player
			Game.getPlayer(name, wins, losses, players);
			
			//Show table
			Game.showHighScores(players);
			
			//Update player file
			Game.writePlayers(players);
			
			//End high score code area
			
			
			
			
			
			//Area to ask to play again
			System.out.println("Would you like to play again? yes/no");
			String userYN = scan.nextLine().toLowerCase();
			if (userYN.startsWith("n")) {
				goAgain = false;
			} else {
				misses = 0;
				blankWord.clear();
			}
			
			
			
			}	
			
		}
	//Close the scanner.
	scan.close();	
	
	}
}
