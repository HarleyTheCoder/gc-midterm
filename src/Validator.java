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
	
	/**
	 * Get any string.
	 */
	//I edited this
	public static String getString(Scanner scnr) {
		// This approach uses exception handling.
		while (true) {
			try {
				if (scnr.hasNext()) {
					return scnr.nextLine();
				} else {
					System.out.print("Input is empty. Please try again: ");
				}
				
			} catch (Exception e) {
				System.out.print("Invalid string. Please try again: ");
			}
		}
	}
	
	//Get integer within a specific range
	public static int getIntInRange(int a, int b, Scanner scan) {
		boolean cont = true;
		while(cont) {
			try {
				int num = Integer.parseInt(scan.nextLine());
				if (num < a || num > b) {
					throw new IndexOutOfBoundsException();
				} else {
					return num;
				}
			} catch (IndexOutOfBoundsException ie) {
				System.out.println("Selection must be between " + a +
						" and " +  b + ". Please try again. (" + a + "-" + b + ")");
			} catch (NumberFormatException e) {
				System.out.println("Input must be a number (" + a + "-" + b + 
									"). Please try again.");
			}
		}
		return -1;
	}
	
	
}
