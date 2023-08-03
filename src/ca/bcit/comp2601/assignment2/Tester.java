package ca.bcit.comp2601.assignment2;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Models a Tester
 *
 * @author Logan Dutton-Anderson
 * @version 1.0
 */
public class Tester {

    /**
     * a)
     * Tries to create four PrimeMinister objects, yet the Singleton will create only one;
     * the others will simply be references to the first. print all four objects to show
     * they all actually reside at the same memory address.
     *
     * b)
     * shows that the BugattiVeyron converts MPH to KMPH by calling its getSpeed() method and showing
     * it's within 0.00001 of 431.30312 KMPH when its speed is set to 268 MPH.
     *
     * c)
     * Shows the command pattern in an OOP approach
     *
     * d)
     * Shows the observer pattern though this example:
     * a news agency can notify channels when it receives news. Receiving news is what changes the state of the news
     * agency, and it causes the channels to be notified.
     */
    public static void test() {
        // a)
        System.out.println("a)");
        PrimeMinister pm1 = PrimeMinister.getInstance();
        System.out.println("Prime Minister 1: " + pm1);

        PrimeMinister pm2 = PrimeMinister.getInstance();
        System.out.println("Prime Minister 2: " + pm2);

        System.out.println("Are the instances the same? " + (pm1 == pm2));
        System.out.println();

        // b)
        System.out.println("b)");
        Movable bugattiVeyron;
        MovableAdapter bugattiVeyronAdapter;

        double convertedSpeed;
        double expectedSpeed;

        bugattiVeyron = new BugattiVeyron();
        bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);

        convertedSpeed = bugattiVeyronAdapter.getSpeed();
        expectedSpeed = 431.30312;

        System.out.println("Bugatti Veyron speed in KMPH: " + convertedSpeed);
        System.out.println("Expected speed in KMPH: " + expectedSpeed);

        assertEquals(bugattiVeyronAdapter.getSpeed(), 431.30312, 0.00001);
        System.out.println();

        // c)
        System.out.println("c)");
        TextFileOperationExecutor textFileOperationExecutor;
        TextFile textFile;

        textFileOperationExecutor = new TextFileOperationExecutor();
        textFile = new TextFile("file1.txt");

        String result1 = textFileOperationExecutor.executeOperation(textFile::open);
        String result2 = textFileOperationExecutor.executeOperation(textFile::save);

        System.out.println("Result of opening file: " + result1);
        System.out.println("Result of saving file: " + result2);
        System.out.println();

        // d)
        System.out.println("d)");
        NewsAgency observable = new NewsAgency();
        NewsChannel observer = new NewsChannel();

        observable.addObserver(observer);
        observable.setNews("news");
        assertEquals(observer.getNews(), "news");

        System.out.println("No error means that they are equal.");
        System.out.println();

        Main.main(new String[0]);
    }
}
