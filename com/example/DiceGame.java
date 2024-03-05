package com.example;

import java.util.Random;
import java.util.Scanner;

/**
 * Dice guessing game.
 *
 * @author Christopher Di Bert
 * @version 1.0
 * @since 1-3-2024
 */
// DiceGame class
public final class DiceGame {

  /** Private constructor to prevent instantiation. */
  private DiceGame() {
    throw new UnsupportedOperationException("Cannot instantiate");
  }

  /**
   * This is the main method.
   *
   * @param args Unused
   */
  public static void main(final String[] args) {
    // Declares maximum and minimum rand num ranges.
    final int maximum = 6;
    final int minimum = 1;
    // Instantiates RNG and scanner.
    Random randGen = new Random();
    Scanner sc = new Scanner(System.in);

    System.out.println("Welcome to the dice guessing game.");
    // Generates random number in range 1-6.
    final int randNum = randGen.nextInt(maximum - minimum + minimum) + minimum;
    // Sets guess variables to be accessed in loop.
    int userGuess = 0;
    int guesses = 0;
    do {
      guesses++;
      try {
        // Asks the user to enter a guess.
        System.out.print("Enter your guess: ");
        userGuess = sc.nextInt();

        // Checks if user's guess is in range (1,6).
        if (userGuess >= minimum && userGuess <= maximum) {
          // Checks if the guess is too large or too small.
          if (userGuess > randNum) {
            System.out.println("Guess too large!");
          }
          if (userGuess < randNum) {
            System.out.println("Guess too small!");
          }
          // If the user entered a number out of range.
        } else {
          System.out.println("You must enter a number from 1-6");
          guesses--;
        }

        // If the user did not enter an integer, continue loop.
      } catch (Exception e) {
        System.out.println("Invalid input!");
        guesses--;
        sc.nextLine();
      }

    } while (userGuess != randNum);

    // Tells the user how many times it took until guessed correctly.
    System.out.println("Took " + guesses + " to guess correctly.");
  }
}
