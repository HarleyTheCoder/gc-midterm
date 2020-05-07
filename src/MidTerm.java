import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MidTerm {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int MISSES_ALLOWED = 6;
		List<String> words = new ArrayList<>();
		String wordToSolve;
		
		//create new player
		System.out.println("What is your name?");
		String name = scan.nextLine();
		Player player2 = new Player(name);
		
		List<String> blankWord; //This is for the display, it might end up in the
						  //HangedMan class
		
		//Set path for the words text file
		String dirPath = "src/";
		Path path = Paths.get(dirPath + "HangManWords.txt");
		
		//Store words from text file into the list
		Game.storeWords(path, words);
		
		while (true) { //While loop for a new game. Goes until user quits.
			
			wordToSolve = Game.selectWord(words); //Pick a word for the game
			blankWord = Game.createEmptyWord(wordToSolve); //Create empty display
														   //of the word.
			
			
	System.out.println(wordToSolve + "\n" + blankWord); //testing code
			
			
			break; //temporary for the sake of ending the loop
		}

	//Close the scanner.
	scan.close();	
	}

}
