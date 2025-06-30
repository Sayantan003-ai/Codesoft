import java.util.Random;
import java.util.Scanner;

public class Task_1_Number_Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int maxAttempts = 7;
        int score = 0;

        System.out.println("**Number guessing Game**");

        boolean keepPlaying = true;

        while (keepPlaying) {
            int target = random.nextInt(max - min + 1) + min;
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            System.out.println("\nKindly Guess a number between the " + min + " and " + max);
            System.out.println("You have " + maxAttempts + " attempts left.\n");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess Number: ");
                int guess;

                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();
                } else {
                    System.out.println("Kindly enter a valid number!");
                    scanner.next(); // Clear the invalid input
                    continue;
                }

                if (guess == target) {
                    System.out.println("Congratulations!! You guessed the number.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < target) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was " + target);
            }

            System.out.println("The Current Score is: " + score);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            keepPlaying = response.equals("yes");
        }

        System.out.println("\nGame over!! Your final score is: " + score);
        scanner.close();
    }
}
