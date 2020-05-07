import java.util.Scanner;

/*
 * Validator() should have methods that: 
 * 1. check for “yes no” 
 * 2. Check that the user entered a letter (not a number, multiple characters, or nothing)
 * 3. find a letter in a string (Return true for a “hit”, meaning the letter was found in the string. Return False for “miss”, meaning it was not.)
 */
public class Validator {
	//code
	
	public String validation(String word, String letter) {
		
		Scanner scnr = new Scanner(System.in);
		
		return "";
	}
	
	public static boolean validation (String word, Scanner letter) {
		String input = letter.next().toLowerCase();
		boolean isValid = word.contains(input);
			while (!isValid) { // keep looping as long as they enter something invalid
				System.out.println("Oops. Try again!.");
				input = letter.next().toLowerCase();
				isValid = word.contains(input);
			}
		
		
		
		return input.startsWith("y");
	}
	
/*
//put the for loop in here to validate all the letters
public static String checker(String x) {
	for (int i = 0; i < word.length(); i++) {}
}
*/
}
