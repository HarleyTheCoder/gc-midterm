import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Store all the game methods here
public class Game {
	
	
	
	//Store the words into a list
	public static void storeWords(Path path, List<String> words) {
		try {
			if (Files.notExists(path)) {
				Files.createFile(path);
			}
			
			List<String> temp = Files.readAllLines(path);
			for (String t: temp) {
				words.add(t);
			}
			
		} catch (IOException e) {
			System.out.println("Error loading file.");
			e.printStackTrace();
		}
	}
	
	//Select a word to use in the game
	public static String selectWord(List<String> words) {
		int num = (int)(Math.random() * words.size());
		String word = words.get(num);
		return word;
	}
	
	//Create the text to display what word to solve
	public static void createEmptyWord (String word, List<String> blankWord) {
		String blank = "_";
		for (int i = 0; i < word.length(); i++) {
			blankWord.add(blank + " ");
		}
	}
	
	//Call the next round, display basic text
	public static int nextRound(List<String> blankWord, String wordToSolve,
									int misses, Scanner scan) {
		
		String guess = "";
		boolean didHit;
		//Display blank word
		String unsolvedWord = Game.makeWordString(blankWord);
		System.out.println("Word: " + unsolvedWord); 
		//Display misses
		System.out.println(HangedMan.missCounter(misses));
		//Get letter to guess
		System.out.print("Guess a letter: ");
		
		guess = Validator.getLetter(scan);
		
		//See if the guess is correct
		didHit = Game.guessChecker(guess.charAt(0), wordToSolve, blankWord);
		if (!didHit) {
			misses++;
		} 
		System.out.println();
		return misses;
	}
	
	public static String makeWordString(List<String> blankWord) {
		String emptyWord = "";
		for (String word: blankWord) {
			emptyWord += word;
		}
			return emptyWord;
	}
	
	
	//Check the guess, replace the letter
	//Returns true or false on whether it found the letter or not
	public static boolean guessChecker (char guess, String wordToSolve, List<String> blankWord) {
		boolean repeated = false;
		boolean correct = false;
		int length = wordToSolve.length();
		List<Character> wordToSolveChars = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			wordToSolveChars.add(wordToSolve.charAt(i));
		}
		 if (!repeated) {
	         int times = 0; 
	         for (int index = 0; index < length; index++) {
	             if (wordToSolveChars.get(index) == guess) {
	                 blankWord.set(index, Character.toString(guess) + " ");
	                 correct = true;
	                 times++;
	             }
	         }
	         if (correct) {
	             System.out.println("The letter " + guess + " is in the word you're trying to solve! "
	             		+ "There are " + times + " " + guess + " 's in the word. Revealing the letter(s): ");
	         } else {
	             System.out.println("Sorry, the letter is not in the word. Your secret word:  ");
	         }
		 }
		 return correct;
	}
	
	
	
	
	//Area to do high score code -
	
	//Print the high score table
	public static void showHighScores(List<Player> players) {
		System.out.println("***HIGH SCORES***");
		System.out.printf("%-8s", "WINS");
		System.out.printf("%-8s", "LOSSES");
		System.out.printf("%-8s", "USER");
		//Now display the data
		for(Player player : players) {
			System.out.printf("\n%-8s", player.getWins());
			System.out.printf("%-8s", player.getLosses());
			System.out.printf("%-8s", player.getName()); 
		}
		System.out.println();
	}
	
	//Rewrite file where Players are stored
	public static void writePlayers(List<Player> players, Path path) {
		List<String> temp = new ArrayList<>();
		for(Player player : players) {

			String line = player.getName() + "@" + player.getWins() + "@" + player.getLosses();
			temp.add(line);
		}

		try {
			Files.write(path, temp, StandardOpenOption.WRITE,
					StandardOpenOption.TRUNCATE_EXISTING); 
		}
		catch (IOException e){
			System.out.println("Error.");
			e.printStackTrace();

		}
		
	}
	
	//Store players into list
	public static void setPlayers(Path path, List<Player> players) {
		try {
			if (Files.notExists(path)) {
				Files.createFile(path);
			}
				
			int index = 0;
			List<String> temp = Files.readAllLines(path);
			for (String t: temp) {
				String[] tempValues = t.split("@");
				players.add(new Player(tempValues[0]));
				players.get(index).setWins(Integer.parseInt(tempValues[1]));
				players.get(index).setLosses(Integer.parseInt(tempValues[2]));
					
				index++;
			}
			
		} catch (IOException e) {
			System.out.println("Error loading file.");
			e.printStackTrace();
		}
		
	}
		
	//See if the player exists, if not then create a new one
	public static void getPlayer(String name, boolean didWin, int wins, int losses, List<Player> players) {
		boolean doesExist = false;
		Player nowPlayer;
		for (Player player: players) {
			if (name.equalsIgnoreCase(player.getName())) {
				System.out.println("User found!\nNow adding to your score.\n");
				nowPlayer = player;
				if (didWin) {
					player.addWins(1);
				} else {
					player.addLosses(1);
				}
				doesExist = true;
				//code to remove old player
			}
		}
		if (!doesExist) {
			System.out.println("\nCreating new user.\n");
			nowPlayer = new Player(name);
			nowPlayer.setWins(wins);
			nowPlayer.setLosses(losses);
			players.add(nowPlayer);
		}
	}
	
	public static boolean checkList (List<String> blankWord) {
		for (String s : blankWord) {
			if (s.contentEquals("_ ")) {
				return true;
			}
		}
		return false;
	}
		
	
}
