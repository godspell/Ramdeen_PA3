/*
    Zahid Ramdeen
    COP3330-19Fall 0002
    Programming Assignment 3 - Problem 1
 */

import java.util.*;
import java.security.SecureRandom;

public class Problem1 {

    /* Required Variables for better Readability */
    enum Difficulty{
        DIFFICULTY_1, DIFFICULTY_2, DIFFICULTY_3, DIFFICULTY_4;
    }
    private final static int DIFFICULTY_1_MAX = 10;
    private final static int DIFFICULTY_2_MAX = 100;
    private final static int DIFFICULTY_3_MAX = 1000;
    private final static int DIFFICULTY_4_MAX = 10000;

    private final static int ADDITION       = 1;
    private final static int MULTIPLICATION = 2;
    private final static int SUBTRACTION    = 3;
    private final static int DIVISION       = 4;
    private final static int RANDOM         = 5;


    // Returns True/False if depending on the user's answer.
    public static Boolean askQuestion(Scanner scnr, SecureRandom rand, Difficulty DIFFICULTY, final int OPERATOR){
        // Generate the required variables to ask the user a question.
        int num1 = getRandomIntegerForDifficulty(rand, DIFFICULTY);
        int num2 = getRandomIntegerForDifficulty(rand, DIFFICULTY);
        int userAnswer;
        boolean checkAnswer = false;

        // Select an operator if the user selected the random option
        int temp_operator = OPERATOR;
        if (temp_operator == RANDOM)
            temp_operator = rand.nextInt(4) + 1; // range (1,4)

        // Ask user the Question and get their answer.
        userAnswer = getUserAnswer(scnr, num1, num2, temp_operator);

        // Check user Answer
        switch(temp_operator){
            case ADDITION:
                checkAnswer = (num1 + num2) == userAnswer;
                break;
            case MULTIPLICATION:
                checkAnswer = (num1 * num2) == userAnswer;
                break;
            case SUBTRACTION:
                checkAnswer = (num1 - num2) == userAnswer;
                break;
            case DIVISION:
                checkAnswer = (num1 / num2) == userAnswer;
                break;
            default:
                System.out.println("ERROR: getUserAnswer(). default statement executed");
                break;
        }
        return checkAnswer;
    }

    // Asks the question depending on the operator and returns the user's answer
    private static int getUserAnswer(Scanner scnr, int num1, int num2, int OPERATOR){
        switch(OPERATOR){
            case ADDITION:
                System.out.printf("How much is %d plus %d? ", num1, num2);
                break;
            case MULTIPLICATION:
                System.out.printf("How much is %d times %d? ", num1, num2);
                break;
            case SUBTRACTION:
                System.out.printf("How much is %d minus %d? ", num1, num2);
                break;
            case DIVISION:
                System.out.printf("How much is %d divided by %d? ", num1, num2);
                break;
            default:
                System.out.println("ERROR: getUserAnswer(). default statement executed");
                break;
        }
        return scnr.nextInt();
    }

    // Gets a random integer (0 to Max) Max depends on difficulty (-1 if an error occurs)
    private static int getRandomIntegerForDifficulty(SecureRandom rand, Difficulty DIFFICULTY){
        switch(DIFFICULTY){
            case DIFFICULTY_1:
                return rand.nextInt(DIFFICULTY_1_MAX);
            case DIFFICULTY_2:
                return rand.nextInt(DIFFICULTY_2_MAX);
            case DIFFICULTY_3:
                return rand.nextInt(DIFFICULTY_3_MAX);
            case DIFFICULTY_4:
                return rand.nextInt(DIFFICULTY_4_MAX);
            default:
                return -1;
        }
    }

    // Return a random message for a Correct answer.
    public static String correctAnswerResponse(SecureRandom rand){
        return "Very good!";
    }

    // Return a random message for an Incorrect answer.
    public static String incorrectAnswerResponse(SecureRandom rand){
        return "Don’t give up!";
    }

    // Returns the difficulty that the user selected
    public static Difficulty getDifficulty(Scanner scnr){
        int userDifficulty;

        // Validate the difficulty setting
        System.out.println("\nPlease select the difficulty (1-4)");
        while(true) {
            userDifficulty = scnr.nextInt();

            if (userDifficulty > 0 && userDifficulty <= 4)
                break;
            System.out.println("Incorrect value entered. Please try again (1-4).");
        }

        switch(userDifficulty){
            case 1: return Difficulty.DIFFICULTY_1;
            case 2: return Difficulty.DIFFICULTY_2;
            case 3: return Difficulty.DIFFICULTY_3;
            case 4: return Difficulty.DIFFICULTY_4;
            default:
                // Should never execute but here just incase.
                System.out.println("ERROR getDifficulty() - user selected the incorrect difficulty.");
                System.out.println("Program will use Difficulty 1 by default.");
                return Difficulty.DIFFICULTY_1;
        }
    }

    // Returns the operator that the user selected
    public static int getOperator(Scanner scnr){
        int userOption;
        String menu =   "\nMENU\n\n" +
                        "1. Addition\n" +
                        "2. Multiplication\n" +
                        "3. Subtraction\n" +
                        "4. Division\n" +
                        "5. Random\n";

        System.out.println(menu);
        System.out.println("Please Select an Option.");
        while(true){
            userOption = scnr.nextInt();

            // exit statement (validate)
            if (userOption > 0 && userOption <= 5)
                break;

            System.out.println("Incorrect Value. Please try again (1-5).");
        }

        return userOption;
    }

    public static void main(String[] args) {
        // Required Variables
        SecureRandom rand = new SecureRandom();
        Scanner scnr = new Scanner(System.in);
        final int MAX_QUESTIONS = 4;
        int userScore = 0;
        Difficulty userSelectedDifficulty;
        int userSelectedOperator;

        // Loops Infinitely
        while(true) {
            // Determine the Difficulty
            userSelectedDifficulty = getDifficulty(scnr);

            // Determine the Operator
            userSelectedOperator = getOperator(scnr);

            // Ask the user questions and count their score.
            for (int i = 0; i < MAX_QUESTIONS; i++) {
                if (askQuestion(scnr, rand, userSelectedDifficulty, userSelectedOperator))
                    userScore++;
            }

            // Display user Results
            if (Double.compare((double) userScore / MAX_QUESTIONS, 0.75) < 0)
                System.out.println("\nPlease ask your teacher for extra help");
            else
                System.out.println("\nCongratulations, you are ready to go to the next level!");

        }
    }
}
