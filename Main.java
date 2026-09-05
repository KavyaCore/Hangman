import java.util.Scanner;
import java.util.Random;

/**
 * Hangman Console Game
 * Classic word-guessing game: guess letters one at a time before
 * running out of attempts.
 *
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // A small word bank to pick from
        String[] words = {"banana", "monkey", "turtle", "cookie", "rabbit", "balloon", "penguin", "rainbow", "dragon", "dolphin"};
        String wordToGuess = words[random.nextInt(words.length)];

        // Tracks which letters in the word have been correctly guessed
        boolean[] guessedPositions = new boolean[wordToGuess.length()];

        int maxAttempts = 6;
        int wrongGuesses = 0;
        String guessedLetters = ""; // keeps track of every letter already tried

        System.out.println("===== Hangman =====");
        System.out.println("Guess the word, one letter at a time!");

        while (wrongGuesses < maxAttempts) {
            System.out.println("\nWord: " + getDisplayWord(wordToGuess, guessedPositions));
            System.out.println("Wrong guesses: " + wrongGuesses + "/" + maxAttempts);
            System.out.print("Guess a letter: ");

            String input = scanner.nextLine().trim().toLowerCase();

            // Instead of using "continue" to skip bad input, we nest everything
            // inside one big if-else so the flow reads top to bottom.
            if (input.length() != 1) {
                System.out.println("Please enter exactly one letter.");

            } else {
                char guess = input.charAt(0);

                // Check if this letter was already guessed
                boolean alreadyGuessed = false;
                for (int i = 0; i < guessedLetters.length(); i++) {
                    if (guessedLetters.charAt(i) == guess) {
                        alreadyGuessed = true;
                    }
                }

                if (alreadyGuessed) {
                    System.out.println("You already guessed that letter. Try a different one.");

                } else {
                    guessedLetters += guess;

                    // Check the guess against every letter in the word
                    boolean correctGuess = false;
                    for (int i = 0; i < wordToGuess.length(); i++) {
                        if (wordToGuess.charAt(i) == guess) {
                            guessedPositions[i] = true;
                            correctGuess = true;
                        }
                    }

                    if (correctGuess) {
                        System.out.println("Correct!");
                    } else {
                        wrongGuesses++;
                        System.out.println("Wrong guess!");
                    }

                    if (isWordFullyGuessed(guessedPositions)) {
                        System.out.println("\nYou guessed it! The word was: " + wordToGuess);
                        System.out.println("You won with " + wrongGuesses + " wrong guess(es).");
                        scanner.close();
                        return;
                    }
                }
            }
        }

        System.out.println("\nOut of attempts! The word was: " + wordToGuess);
        System.out.println("Better luck next time.");
        scanner.close();
    }

    // Builds the word display string, showing guessed letters and underscores for the rest
    private static String getDisplayWord(String word, boolean[] guessedPositions) {
        String display = "";
        for (int i = 0; i < word.length(); i++) {
            if (guessedPositions[i]) {
                display += word.charAt(i);
            } else {
                display += "_";
            }
            display += " ";
        }
        return display.trim();
    }

    // Checks if every letter in the word has been guessed.
    // Uses a plain indexed for loop instead of a for-each loop.
    private static boolean isWordFullyGuessed(boolean[] guessedPositions) {
        boolean allGuessed = true;
        for (int i = 0; i < guessedPositions.length; i++) {
            if (guessedPositions[i] == false) {
                allGuessed = false;
            }
        }
        return allGuessed;
    }
}
