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
