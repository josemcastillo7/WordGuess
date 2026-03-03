package com.github.zipcodewilmington;
import java.util.Random;
import java.util.Scanner;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */

  
public class WordGuess {
    private Scanner scanner;

    private String[] wordBank = {"hello", "world", "java", "programming", "challenge","realmadrid","fishbee"};
    private char[] guessedLetters;
    private String secretWord;
    private int attemptsAllowed = 10;

    

    
    

    public WordGuess(){
        this.scanner = new Scanner(System.in);

        Random random = new Random();
        int index = random.nextInt(wordBank.length);
        this.secretWord = wordBank[index];
        this.guessedLetters = new char[secretWord.length()];
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';    
        }
    }



public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    WordGuess game = new WordGuess();
    game.runGame();
    
}


    public String getWord(){
        return this.secretWord;
    }

    public String getDisplayStatus(){
        String output = "";
        for (char c : guessedLetters) {
            output += c + " ";
        }
        return output;
    
    }

    public boolean checkGuess(char letter){
        boolean found = false;
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                guessedLetters[i] = letter;
                found = true;
            }
        }
        return found;
    }

    public void runGame(){


    while(getDisplayStatus().contains("_") && attemptsAllowed > 0) {
        System.out.println("Attempts remaining: " + attemptsAllowed);
        System.out.println("Current word: " + getDisplayStatus());
        System.out.print("Enter a letter to guess: ");
        char guess = scanner.nextLine().charAt(0);
        if (checkGuess(guess)) {
            System.out.println("Correct!");
        }
         
        else {
            System.out.println("Incorrect!");
            attemptsAllowed--;

        }

       
    }


     
    if (!getDisplayStatus().contains("_")) {
        System.out.println("Congratulations! You've guessed the word: " + secretWord);
    } else {
        System.out.println("Game over! The secret word was: " + secretWord);
    
}

}
}

