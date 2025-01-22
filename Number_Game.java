import java.util.Random;
import java.util.Scanner;

public class Number_Game {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int score = 0;

        System.out.println("\n******** WELCOME TO THE NUMBER GAME ********");

        boolean playAgain = true;
        int totalRounds = 0;

        while (playAgain) {

            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            totalRounds++;
            System.out.println("\nRound: " + totalRounds);
            System.out.println("\nSystem has generated a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number. Good Luck!");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.println("\nAttempt: " + (attempts + 1) + "/" + maxAttempts);
                System.out.print("Enter your guess => ");

                if (sc.hasNextInt()) {
                    int userGuess = sc.nextInt();
                    
                    if (userGuess < generatedNumber) {
                        System.out.println("\nIt's too low!");
                    } 
                    else if (userGuess > generatedNumber) {
                        System.out.println("\nIt's too high!");
                    } 
                    else {
                        System.out.println("Bullseye!! You guessed the right one.");
                        guessedCorrectly = true;
                        score++;
                    }

                    attempts++;
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.next(); // Consume the invalid input
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nOops! You have used up all your attempts.");
                System.out.println("The correct number was: " + generatedNumber);
            }

            System.out.print("\nWould you like to play this game again? (Yes/No) => ");
            String playAgainResponse = sc.next().trim();

            if (!playAgainResponse.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame over! Your score is: " + score);
        System.out.println("Thanks for playing!");
        sc.close();
    }
}
