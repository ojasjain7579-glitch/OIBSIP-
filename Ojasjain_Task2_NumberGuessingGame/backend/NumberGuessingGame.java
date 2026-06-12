package backend;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int rounds = 3;

        System.out.println("===== NUMBER GUESSING GAME =====");

        for (int round = 1; round <= rounds; round++) {

            int number = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nRound " + round);
            System.out.println("Guess a number between 1 and 100");

            while (!guessed) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess == number) {

                    System.out.println("Correct Guess!");
                    score += (10 - attempts);

                    guessed = true;

                } else if (guess < number) {

                    System.out.println("Too Low!");

                } else {

                    System.out.println("Too High!");
                }
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Final Score: " + score);

        sc.close();
    }
}