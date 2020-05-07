import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * The HangMan() Class object could implement an interface, if you want. 
 * It will need String variables to set up the display. 
 * (Ex. The man hanging, the blanks for the answer _ _ _ _, etc.)
 * 
 * 1. Getters and setters
 * 2. A list with possible words
 * 3. A method that fills that list based on a text file as soon as the Class Object is created
 * 4. A method to select a random word, stores it as variable inside class
 * 5. String with blanks _ _ _ _, the number of blanks depending on the “word”
 * 6. Method that replaces a blank with appropriate letter if there’s a match
 * 7. ….continued
 */

public class HangedMan {
	
	public static String allTries() {
		return " ____"+"\n"+" |"+"\n"+" |"+"\n"+"_|_"+"\n";
	}
	public static String oneMiss() {
		return " ____"+"\n"+" |  O"+"\n"+" |"+"\n"+"_|_"+"\n";
	}
	public static String twoMisses() {
		return " ____"+"\n"+" |  O"+"\n"+" |  |"+"\n"+"_|_"+"\n";
	}
	public static String threeMisses() {
		return " ____"+"\n"+" | \\O"+"\n"+" |  |"+"\n"+"_|_"+"\n";
	}
	public static String fourMisses() {
		return " ____"+"\n"+" | \\O/"+"\n"+" |  |"+"\n"+"_|_"+"\n";
	}
	public static String fiveMisses() {
		return " ____"+"\n"+" | \\O/"+"\n"+" |  |"+"\n"+" | /"+"\n"+"_|_"+"\n";
	}
	public static String gameOver() {
		return " ____"+"\n"+" | \\O/"+"\n"+" |  |"+"\n"+" | / \\"+"\n"+"_|_"+"\n"+"GAME OVER";
	}
	
	HashMap<Integer, String> hangManMap = new HashMap<>();
	
	hangManMap.put(0, allTries());
	hangManMap.put(1, oneMiss());
	hangManMap.put(2, twoMisses());
	hangManMap.put(3, threeMisses());
	hangManMap.put(4, fourMisses());
	hangManMap.put(5, fiveMisses());
	hangManMap.put(6, gameOver());
	
	public static int missCounter(char guess) {
		if (wordToSolve.contains(guess)) {
			return hangManMap.get(0);
		}else {
			for ()
		}
	}
	
}
