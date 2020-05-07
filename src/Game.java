import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
	public static String createEmptyWord (String word) {
		String emptyWord = "";
		String blank = "_";
		for (int i = 0; i < word.length(); i++) {
			emptyWord += blank + " ";
		}
		return emptyWord;
	}
	
	//Guess a letter
	public static void guessLetter(String word, String letter) {
		
	}
	
	//temp validator
	public static boolean isInWord(String word, String letter) {
		if (word.contains(letter)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String getLetter(Scanner scan) {
		String regex = "[A-Za-z]";
		while (true) {
			try {
				String letter = scan.nextLine().toLowerCase();
				if (letter.isEmpty()) {
					System.out.print("Nothing was entered. Please enter a letter: ");
				} else if (!letter.matches(regex)) {
					System.out.print("Error. Please enter a single letter: ");
				} else {
					return letter;
				}
			} catch (Exception e) {
				System.out.print("Something went wrong. Please try again: ");
			}
		}
		
	}
	
}
