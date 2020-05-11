import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
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
				words.add(t.trim().toUpperCase()); //Added trim to eliminate blank space issue
			}
			
		} catch (IOException e) {
			System.out.println("Error loading file.");
			e.printStackTrace();
		}
	}
	
	//Let user decide how long they want the word to be
	/*
	 * (Rather than storing separate files, the program
	 * stores all words with that number of letters into a list.)
	 */
	public static List<String> setWordLength(List<String> words, Scanner scan) {
		List<String> newWords = new ArrayList<>();
		System.out.print("How many letters should the word be? (4-12): ");
		int wordLength = Validator.getIntInRange(4, 12, scan);
		for (String word: words) {
			if (word.length() == wordLength) {
				newWords.add(word);
			}
		}
		return newWords;
	}
	
	
	//Select a word to use in the game
	public static String selectWord(List<String> words) {
		int num = (int)(Math.random() * words.size());
		String word = words.get(num);
		return word.toUpperCase();
	}
	
	//Create the text to display what word to solve
	public static void createEmptyWord (String word, List<String> blankWord) {
		String blank = "_";
		for (int i = 0; i < word.length(); i++) {
			if (i == word.length() - 1) {
				blankWord.add(blank);
			} else {
				blankWord.add(blank + " ");
			}
		}
	}
	
	//Call the next round, display basic text
	public static int nextRound(List<String> blankWord, String wordToSolve,
									int misses, Scanner scan, List<String> usedLetters) {
		
		String guess = "";
		boolean didHit;
		//Display blank word
		String unsolvedWord = Game.makeWordString(blankWord);
		System.out.println("Word: " + unsolvedWord); 
		//Display misses
		System.out.println(HangedMan.missCounter(misses));
		//Show the used letters
		Game.showUsedLetters(usedLetters);
		//Get letter to guess
		System.out.print("Guess a letter: ");
		
		guess = Validator.getLetter(scan).toUpperCase();
		while (usedLetters.contains(guess)) { //fixed this so it keeps looping if letter
											  //was already guessed.
			System.out.print("You've guessed that letter already, try again: ");
			guess = Validator.getLetter(scan).toUpperCase();
		}
		usedLetters.add(guess.toUpperCase());
		
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
			wordToSolveChars.add(wordToSolve.toUpperCase().charAt(i));
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
	             if (times == 1) {
	            	 System.out.println("The letter " + guess + " is in the word you're trying to solve! "
	 	             		+ "\nThere is " + times + " \"" + guess + "\" in the word.");
	             } else {
	            	 System.out.println("The letter " + guess + " is in the word you're trying to solve! "
	 	             		+ "\nThere are " + times + " \"" + guess + "\"'s in the word.");
	             }
	         } else {
	             System.out.println("Sorry, the letter is not in the word.");
	         }
		 }
		 return correct;
	}
	
	//Show what letters have been used
	public static void showUsedLetters(List<String> letters) {
		Collections.sort(letters);
		System.out.print("Used letters: ");
		int counter = 0;
		String letterString = "";
		if (letters.isEmpty()) {
			System.out.print("none\n");
		} else {
			for (String letter: letters) {
				if (letterString.equals("")) {
					letterString = letter;
				} else if (counter == 7) {
					letterString += ",\n              " + letter;
				} else {
					letterString += ", " + letter;
				}
				counter++;
			}
			System.out.print(letterString + "\n");
		}
	}
	
	
	
	//Area to do high score code -
	
	//Print the high score table
	public static void showHighScores(List<Player> players) {
		//Sort players by score
		Collections.sort(players, new SortByScore());
		System.out.println("***HIGH SCORES***");
		System.out.printf("%-8s", "WINS");
		System.out.printf("%-8s", "LOSSES");
		System.out.printf("%-8s", "USER");
		//Now display the data
		for(Player player : players) {
			System.out.printf("\n%-8s", player.getWins());
			System.out.printf("%-8s", player.getLosses());
			System.out.printf("%-8s", player.getName()); 
		}
		System.out.println();
	}
	
	//See more stats if they want to see them
	public static void showMoreStats(List<Player> players) {
		Collections.sort(players, new SortByStats());
		//Calculation variables
		String percentWins = "";
		String avgGuesses = "";
		String avgWordLength = "";
		//Set up display
		System.out.println();
		System.out.printf("%-15s", "USER");
		System.out.printf("%-15s", "% OF");
		System.out.printf("%-15s", "AVG # OF");
		System.out.printf("%-15s", "AVG WORD");
		System.out.print("\n");
		System.out.printf("%-15s", "NAME");
		System.out.printf("%-15s", "WINS");
		System.out.printf("%-15s", "GUESSES");
		System.out.printf("%-15s", "LENGTH");
		//Now display the data
		for(Player player : players) {
			percentWins = player.calcWinPercent();
			avgGuesses = player.calcAvgGuesses();
			avgWordLength = player.calcAvgLength();
			System.out.printf("\n%-15s", player.getName()); 
			System.out.printf("%-15s", percentWins);
			System.out.printf("%-15s", avgGuesses);
			System.out.printf("%-15s", avgWordLength);
		}
		System.out.println();
	}
	
	//Rewrite file where Players are stored
	public static void writePlayers(List<Player> players, Path path) {
		List<String> temp = new ArrayList<>();
		for(Player player : players) {

			String line = player.getName() + "@" + player.getWins() + "@" + player.getLosses() + 
					"@" + player.getGuessNums() + "@" + player.getWordLengths();
			temp.add(line);
		}

		try {
			Files.write(path, temp, StandardOpenOption.WRITE,
					StandardOpenOption.TRUNCATE_EXISTING); 
		}
		catch (IOException e){
			System.out.println("Error.");
			e.printStackTrace();

		}
		
	}
	
	//Store players into list
	public static void setPlayers(Path path, List<Player> players,
								boolean didWin, int guesses, int wordLength) {
		try {
			if (Files.notExists(path)) {
				Files.createFile(path);
			}
				
			int index = 0;
			List<String> temp = Files.readAllLines(path);
			for (String t: temp) {
				String[] tempValues = t.split("@");
				players.add(new Player(tempValues[0]));
				players.get(index).setWins(Integer.parseInt(tempValues[1]));
				players.get(index).setLosses(Integer.parseInt(tempValues[2]));
				try { //this is in case nothing is in the file for this part
					players.get(index).setGuessNums(tempValues[3]);
				} catch (Exception e) {
					if (didWin) {
						players.get(index).setGuessNums(guesses + "");
					} else {
						players.get(index).setGuessNums("-1");
					}
					
				}
				try { //this is in case nothing is in the file for this part
					players.get(index).setWordLengths(tempValues[4]);
				} catch (Exception e) {
					players.get(index).setWordLengths(wordLength + "");
				}
					
				index++;
			}
			
		} catch (IOException e) {
			System.out.println("Error loading file.");
			e.printStackTrace();
		}
		
	}
		
	//See if the player exists, if not then create a new one
	//Also update player if it is found
	public static void getPlayer(String name, boolean didWin, int guesses, int wordLength,
								int wins, int losses, List<Player> players) {
		boolean doesExist = false;
		Player nowPlayer;
		for (Player player: players) {
			if (name.equalsIgnoreCase(player.getName())) {
				System.out.println("User found!\nNow adding to your score.\n");
				nowPlayer = player;
				if (didWin) {
					player.addWins(1);
					player.addGuessNums(guesses + "");
				} else {
					player.addLosses(1);
				}
				player.addWordLengths(wordLength + "");
				doesExist = true;
			}
		}
		if (!doesExist) {
			System.out.println("\nCreating new user.\n");
			nowPlayer = new Player(name);
			nowPlayer.setWins(wins);
			nowPlayer.setLosses(losses);
			if (didWin) {  //Only add num of guesses if they won
				nowPlayer.setGuessNums(guesses + "");
			}
			nowPlayer.setWordLengths(wordLength + "");
			players.add(nowPlayer);
		}
	}
	
	//Check the blanks in the blankWord to see if it's finished
	public static boolean checkList (List<String> blankWord) {
		for (String s : blankWord) {
			if (s.contains("_")) {
				return true;
			}
		}
		return false;
	}
	
	//Tool to see if there are repeats in word list
	public static void findRepeats(List<String> words) {
		List<String> repeats = new ArrayList<>();
		for (int i = 0; i < words.size(); i++) {
			for (int a = 0; a < words.size(); a++) {
				if (!repeats.contains(words.get(i))) {
					if (i != a && words.get(i).equalsIgnoreCase(words.get(a))) {
						repeats.add(words.get(i));
					}
				}
				
			}
		}
		//Display repeats
		if (repeats.isEmpty()) {
			System.out.println("No repeats");
		} else {
			for (String repeat: repeats) {
				System.out.println(repeat);
			}
		}
		
	}
	
}
