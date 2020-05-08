import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Validator() should have methods that: 
 * 1. check for “yes no” 
 * 2. Check that the user entered a letter (not a number, multiple characters, or nothing)
 * 3. find a letter in a string (Return true for a “hit”, meaning the letter was found in the string. Return False for “miss”, meaning it was not.)
 */
public class Validator {
	
	public static boolean isInWord(String word, String letter) {
		letter = letter.toLowerCase();
		if (word.contains(letter)) {
			return true;
		} else { return false;}
		
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
	
	
	//Area to do high score code -
	//**Move this into the Game class
	public static void getPlayers(Path path, List<Player> players) {
		try {
			if (Files.notExists(path)) {
				Files.createFile(path);
			}
			
			int tempInt = 0;
			List<String> temp = Files.readAllLines(path);
			for (String t: temp) {
				String[] tempValues = t.split("@");
				players.add(new Player(tempValues[0]));
				
				
				tempInt++;
			}
			
		} catch (IOException e) {
			System.out.println("Error loading file.");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}
