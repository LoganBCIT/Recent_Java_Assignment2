package ca.bcit.comp2601.assignment2;

/**
 * Models an example class that implements the singleton design pattern.
 * This class ensures that only one instance of PrimeMinister can be created.
 */
public class PrimeMinister {
    private static PrimeMinister pm;

    static {
        pm = null;
    }

    /**
     * Constructs a PrimeMinister object.
     * This constructor is private to prevent direct instantiation of PrimeMinister objects from outside the class.
     */
    private PrimeMinister() {
    }

    /**
     * Returns the instance of PrimeMinister.
     * If no instance exists, a new instance is created and returned.
     *
     * @return the instance of PrimeMinister
     */
    public static PrimeMinister getInstance() {
        if (pm == null) {
            pm = new PrimeMinister();
        }
        return pm;
    }
}
