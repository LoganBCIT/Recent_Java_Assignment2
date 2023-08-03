package ca.bcit.comp2601.assignment2;

import java.util.Scanner;

/**
 * Models a Main
 *
 * @author Logan Dutton-Anderson
 * @version 1.0
 */
public class Main {

    public static final int FIRST_OPTION;
    public static final int SECOND_OPTION;
    public static final int THIRD_OPTION;
    public static final int FOURTH_OPTION;
    public static final int FIFTH_OPTION;
    private static final int MIN_CHOICE;
    private static final int MAX_CHOICE;
    private static final int NONE;

    private static boolean guiOpen = false;

    static {
        FIRST_OPTION = 1;
        SECOND_OPTION = 2;
        THIRD_OPTION = 3;
        FOURTH_OPTION = 4;
        FIFTH_OPTION = 5;
        MIN_CHOICE = 1;
        MAX_CHOICE = 5;
        NONE = 0;

    }

    /**
     * Prompts the user to choose an option and performs the corresponding action.
     *
     * @param args the command-line arguments
     */
    public static void main(final String[] args) {
        boolean quit;
        quit = false;

        Scanner scanner;
        scanner = new Scanner(System.in);

        int userChoice;
        userChoice = NONE;

        while (!quit) {
            printMainMenu();

            String userInput;
            userInput = scanner.nextLine();

            try {
                userChoice = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("You must enter an integer!");
                continue;
            }

            if (userChoice < MIN_CHOICE || userChoice > MAX_CHOICE) {
                System.out.println("Invalid choice: " + userChoice);
            } else {
                quit = true;
            }
        }


        if (userChoice == FIRST_OPTION) {
            System.out.println("Showing Lesson 8: GUI:\n");

            CountryList countryList;
            countryList = new CountryList();

        } else if (userChoice == SECOND_OPTION) {
            System.out.println("Showing Lesson 9: Streams and Filters:\n");

            CountryProcessor countryProcessor;
            countryProcessor = new CountryProcessor();
            countryProcessor.processCountries();

        } else if (userChoice == THIRD_OPTION) {
            System.out.println("Showing Lesson 10: Design Patterns:\n");
            Tester.test();

        } else if (userChoice == FOURTH_OPTION) {
            System.out.println("Showing Lesson 11: Concurrency:\n");
            DivideAndConquerSum.concurrentMain(scanner);

        } else if (userChoice == FIFTH_OPTION) {
            System.out.println("Program Exiting...");
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMainMenu() {
        System.out.println();
        System.out.println("Type 1 for GUI");
        System.out.println("Type 2 for Streams and Filters");
        System.out.println("Type 3 for Design Patterns");
        System.out.println("Type 4 for Concurrency");
        System.out.println("Type 5 to Quit");
        System.out.println();
        System.out.print("Your choice: ");
    }
}
