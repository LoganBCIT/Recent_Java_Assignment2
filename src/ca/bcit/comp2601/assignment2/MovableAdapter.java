package ca.bcit.comp2601.assignment2;

/**
 * Models a MovableAdapter interface.
 * This interface represents an adapter that adapts a Movable object to provide its speed in kilometers per hour (KM/H).
 * Implementing classes should define the behavior of getting the speed.
 * The speed is measured in kilometers per hour.
 *
 * Note: The MovableAdapter interface assumes that the underlying Movable object already provides speed in miles per hour (MPH).
 * The adapter's responsibility is to convert the speed from MPH to KM/H.
 *
 * @author Logan Dutton-Anderson
 * @version 1.0
 */
public interface MovableAdapter {
    /**
     * Returns the speed of the adapted Movable object in kilometers per hour (KM/H).
     *
     * @return the speed in kilometers per hour
     */
    double getSpeed();
}
