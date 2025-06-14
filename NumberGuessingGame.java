import java.util.*;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int round = 0;

        while (playAgain) {
            int targetNumber = rd.nextInt(100) + 1;
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n🎮 Round " + (round + 1));
            System.out.println("Guess a number between 1 and 100. You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalScore += (maxAttempts - attempts + 1);
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("🔻 Too low!");
                } else {
                    System.out.println("🔺 Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts! The correct number was: " + targetNumber);
            }

            round++;
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");
        }

        System.out.println("\n🏁 Game Over!");
        System.out.println("Rounds played: " + round);
        System.out.println("Total score: " + totalScore);
    }
}
