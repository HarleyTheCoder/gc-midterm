import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
	
	public static void writePlayers(List<Player> players) {
		List<String> temp = new ArrayList<>();
		Path path1 = Paths.get("src/Players.txt");
		for(Player player : players) {
			temp.add(player.getName() + "@" + player.getWins() + "@" + player.getLosses());
			try {
				Files.write(path1, temp, StandardOpenOption.WRITE, StandardOpenOption.APPEND); 
			}
			catch (IOException e){
				System.out.println("Error.");
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
