package ca.bcit.comp2601.assignment2;

/**
 * Models a MovableAdapterImpl class that implements the MovableAdapter interface.
 * This class adapts the behavior of a Movable object to support the MovableAdapter interface.
 * It converts the speed from MPH to KMPH.
 *
 * @author Logan Dutton-Anderson
 * @version 1.0
 */
public class MovableAdapterImpl implements MovableAdapter {
    private Movable luxuryCars;

    /**
     * Constructs a MovableAdapterImpl object.
     *
     * @param luxuryCars the luxury cars object to be adapted
     */
    public MovableAdapterImpl(Movable luxuryCars) {
        this.luxuryCars = luxuryCars;
    }

    @Override
    public double getSpeed() {
        return convertMPHtoKMPH(luxuryCars.getSpeed());
    }

    /**
     * Converts the speed from MPH to KMPH.
     *
     * @param mph the speed in miles per hour
     * @return the speed in kilometers per hour
     */
    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}
