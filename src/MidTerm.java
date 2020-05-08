import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MidTerm {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		final int MISSES_ALLOWED = 6;
		int misses = 0; //might be temporary
		String guess = ""; //might be temp
		String wordToSolve;
		List<String> words = new ArrayList<>();
		List<String> blankWord = new ArrayList<>(); //This is for the display, it might end up in the
			//HangedMan class

		
		
		//create new player
		/*System.out.println("What is your name?");
		String name = scan.nextLine();
		Player player2 = new Player(name);
		*/
		
		
		//Set path for the words text file
		String dirPath = "src/";
		Path path = Paths.get(dirPath + "HangManWords.txt");
		
		//Store words from text file into the list
		Game.storeWords(path, words);
		
		while (true) { //While loop for a new game. Goes until user quits.
			
			wordToSolve = Game.selectWord(words); //Pick a word for the game
			Game.createEmptyWord(wordToSolve, blankWord); //Create empty display
															//of the word.
			
			//TEST CODE - TEMPORARY
			System.out.println(wordToSolve);//test - delete later
			
			//Show new round until player misses too many times
			while (misses <= MISSES_ALLOWED) {
				Game.nextRound(blankWord, wordToSolve, misses, scan);
				
				//this next part is temporary to prevent infinite loop
				misses++; //temp
			}
			
			
			
	//System.out.println(wordToSolve + "\n" + Game.printWord(blankWord)); //testing code
			
			
			break; //temporary for the sake of ending the loop
		}

	//Close the scanner.
	scan.close();	
	}

}
