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
		int guesses = 0;
		boolean didWin = false;
		String name = "";
		
		final int MISSES_ALLOWED = 6;
		int misses = 0;
		String wordToSolve;
		List<String> words = new ArrayList<>();
		List<String> blankWord = new ArrayList<>(); //This is for the display
		List<String> usedLetters = new ArrayList<>();
		List<String> wordsByLength = new ArrayList<>();
		
		
		//Set path for the words text file
		String dirPath = "src/";
		Path path = Paths.get(dirPath + "HangManWords.txt");
		
		//Store words from text file into the list
		Game.storeWords(path, words);
		boolean goAgain = true;
		
		//Print welcome message
		String welcome = " _         _   _       ____  _                \r\n" + 
				" | |    ___| |_( )___  |  _ \\| | __ _ _   _    \r\n" + 
				" | |   / _ \\ __|// __| | |_) | |/ _` | | | |   \r\n" + 
				" | |__|  __/ |_  \\__ \\ |  __/| | (_| | |_| |   \r\n" + 
				" |_____\\___|\\__| |___/ |_|   |_|\\__,_|\\__, |   \r\n" + 
				"  _   _                     __  __    |___/    \r\n" + 
				" | | | | __ _ _ __   __ _  |  \\/  | __ _ _ __  \r\n" + 
				" | |_| |/ _` | '_ \\ / _` | | |\\/| |/ _` | '_ \\ \r\n" + 
				" |  _  | (_| | | | | (_| | | |  | | (_| | | | |\r\n" + 
				" |_| |_|\\__,_|_| |_|\\__, | |_|  |_|\\__,_|_| |_|\r\n" + 
				"                    |___/                      ";
		
		System.out.println(welcome + "\n");
		
		
		while (goAgain) { //While loop for a new game. Goes until user quits.
			
			wordsByLength = Game.setWordLength(words, scan);
			wordToSolve = Game.selectWord(wordsByLength).toUpperCase(); //Pick a word for the game
			Game.createEmptyWord(wordToSolve, blankWord); //Create empty display of the word.
			
			
			//Show new round until player misses too many times
			while (misses < MISSES_ALLOWED && Game.checkList(blankWord)) {
				misses = Game.nextRound(blankWord, wordToSolve, misses, scan, usedLetters);
				if (misses == 6) {
					System.out.println(HangedMan.gameOver());
					didWin = false;
					losses += 1;
				} 
				guesses++;
			}
			if (!Game.checkList(blankWord)) {
				System.out.println("Congratulations, you've won!");
				didWin = true;
				wins += 1;
			}
			
			//Moved this to display it no matter the outcome
			System.out.println("The word was " + wordToSolve + "."); 
			
			
					
			//Area to test high score code
			//Keep separate
			List <Player> players = new ArrayList<>();
			Path playerPath = Paths.get(dirPath + "Players.txt");
			
			//Load existing players in a list
			Game.setPlayers(playerPath, players, didWin, guesses, wordToSolve.length());
			
			//Get user name,
			System.out.print("\nEnter a user name for the high score table: ");
			name = Validator.getString(scan);
			
			//Check if name exists, if not create new player
			Game.getPlayer(name, didWin, guesses, wordToSolve.length(),
							wins, losses, players);
			
			//Show table
			Game.showHighScores(players);
			
			//Update player file
			Game.writePlayers(players, playerPath);
			
			//Ask to show more stats, if so then show
			System.out.print("\nWould you like to see more user stats? yes/no: ");
			if (Validator.getYesNo(scan)) {
				Game.showMoreStats(players);
			}
			
			//End high score code area
			
			
			
			//Area to ask to play again
			System.out.println();
			System.out.print("Would you like to play again? yes/no: ");
			if (!Validator.getYesNo(scan)) {   //I fixed this code to make sure we get an
				goAgain = false;   			   //answer, it would have just counted as "no"
				System.out.println("\nGoodbye!");//if they inputed incorrectly.
			} else {                        
				misses = 0;
				wins = 0;
				losses = 0;
				guesses = 0;
				blankWord.clear();
				usedLetters.clear();
				goAgain = true; //this needs to be here to work right
				System.out.println("\n\n" + welcome);
			}
			
			
			
		}	
			
		
	//Close the scanner.
	scan.close();	
	
	}
}
