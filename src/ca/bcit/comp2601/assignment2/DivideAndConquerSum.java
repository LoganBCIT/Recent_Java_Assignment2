package ca.bcit.comp2601.assignment2;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

/**
 * Models a sum calculator that uses divide and conquer with concurrency.
 * The sum is calculated for a given range of numbers using multiple threads.
 * The range start and end values, as well as the number of threads, can be provided by the user.
 * The sum calculation is performed using the ForkJoinPool framework.
 *
 * @author Logan Dutton-Anderson
 * @version 1.0
 */
public class DivideAndConquerSum {

    /**
     * Calculates the sum of numbers within the specified range using multiple threads.
     *
     * @param rangeStart       the start of the range (inclusive)
     * @param rangeEnd         the end of the range (inclusive)
     * @param numberOfThreads  the number of threads to use for calculation
     * @return the sum of numbers within the range
     */
    static int sum(int rangeStart, int rangeEnd, int numberOfThreads) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(numberOfThreads);
        try {
            return forkJoinPool.submit(() ->
                    IntStream.rangeClosed(rangeStart, rangeEnd)
                            .parallel()
                            .sum()
            ).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Main method for performing concurrent sum calculation using user input.
     * Prompts the user to enter the range start, range end, and number of threads,
     * and calculates the sum of numbers within the range using multiple threads.
     */
    static void concurrentMain(Scanner input) {
        int rangeStart, rangeEnd, numberOfThreads;
        do {
            System.out.print("Enter the range start: ");
            rangeStart = input.nextInt();

            System.out.print("Enter the range end: ");
            rangeEnd = input.nextInt();

            System.out.print("Enter the number of threads: ");
            numberOfThreads = input.nextInt();

            if (rangeStart >= rangeEnd || numberOfThreads < 1) {
                System.out.println("Warning: range start should be less than range end. Also, the number of threads should not be less than 1.");
            }
        } while (rangeStart >= rangeEnd || numberOfThreads < 1);

        int sum = DivideAndConquerSum.sum(rangeStart, rangeEnd, numberOfThreads);

        System.out.println(String.format("Sum of numbers in the range [%s, %s] found in %s threads is %s",
                rangeStart, rangeEnd, numberOfThreads, sum));

        Main.main(new String[0]);
    }
}
