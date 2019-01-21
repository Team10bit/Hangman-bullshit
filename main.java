import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class main {

	static String name;
	static Random ran = new Random();
	static String selectedWord;
	static String appHint;
	static boolean wordNotGuessed = true;
	static boolean firstGuess = true;
	
	static String[] Words = {"Holly", "Jasmine", "Pussy", "Death", "Nibbles"};
	static String[] Hints = {"A woman I've recently had sex with...", "Woman I want to have sex with...", 
																			"\"I love... \"", "What I'm looking forward to...", "My dog."};
	
	static ArrayList<String> correctGuesses = new ArrayList<String>();
	
	static Scanner input = new Scanner(System.in);
	
	static String guessedWord = "";
	
	static int lives = 5;
	
	static String guess;
	
	static String guessed;
	
	static String blank = " _ ";
	
	
	public static void main(String[] args) {
		
	switch(ran.nextInt(Words.length)) {
	
	case 0:
		selectedWord = Words[0].toUpperCase();
		appHint = Hints[0];
		break;
	case 1:
		selectedWord = Words[1].toUpperCase();
		appHint = Hints[1];
		break;
	case 2:
		selectedWord = Words[2].toUpperCase();
		appHint = Hints[2];
		break;
	case 3:
		selectedWord = Words[3].toUpperCase();
		appHint = Hints[3];
		break;
	case 4:
		selectedWord = Words[4].toUpperCase();
		appHint = Hints[4];
		break;
		}
			
	
			
	for(int i = 0; i < selectedWord.length(); i++) {
		System.out.print(blank);
	}
	
	
	System.out.println("\nYour hint is: " + appHint);
	
	
	
	while(lives > 0) {
		guess = input.next().toUpperCase();
		if(selectedWord.contains(guess) && wordNotGuessed && firstGuess) {
			correctGuesses.add(guess);
			guessedWord = guessedWord + guess;
			System.out.println("\nYou guessed correctly! Guess again!");
			for(int i = 0; i < selectedWord.length(); i++) {		//LETTER SORTER FOR REVEALED WORD
				if(selectedWord.indexOf(guess) == i) {
						System.out.print(guess);
					}else {
						System.out.print(blank);
					}
			 	}
			firstGuess = false;
		}else if(selectedWord.contains(guess) && wordNotGuessed) {
			correctGuesses.add(guess);
			for(int i = 0; i < selectedWord.length(); i++) {		//LETTER SORTER FOR REVEALED WORD
				if(selectedWord.indexOf(guess) == i) {
						System.out.print(guess);
					}else {
						System.out.print(blank);
					}
			 	}
			guessedWord = guessedWord + guess;
			System.out.println("\nYou guessed correctly! Guess again! " + guessedWord);
		}else if(!selectedWord.contains(guess) && wordNotGuessed) {
			lives--;
			System.out.println("Wrong guess. Try again, dumbass! " + lives);
		}else if(lives == 0){
			System.out.println("Game over. Kill yourself, you stupid fuck");
		}
		 if(checkWord(guessedWord, selectedWord)) {
			 System.out.println("Congratulations, you won!");
		 }
		}
	}
	
	private static boolean checkWord(String firstStr, String secondStr) {
		char[] first = firstStr.toCharArray();
		char[] second = secondStr.toCharArray();
		Arrays.sort(first);
		Arrays.sort(second);
		return Arrays.equals(first, second);
	}
	
}
