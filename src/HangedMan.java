import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	public static String missCounter(int misses) {
		if (misses == 1) {
			return oneMiss();
		}else if (misses == 2) {
			return twoMisses();
		}else if (misses == 3) {
			return threeMisses();
		}else if (misses == 4) {
			return fourMisses();
		}else if (misses == 5) {
			return fiveMisses();
		}else if (misses == 6) {
			return gameOver();
		}else {
			return allTries();
		}
		
	}
}
