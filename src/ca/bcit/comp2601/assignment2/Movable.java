package ca.bcit.comp2601.assignment2;

/**
 * Models a Movable interface.
 * This interface represents a movable object that can provide its speed.
 * Implementing classes should define the behavior of getting the speed.
 * The speed is measured in miles per hour (MPH).
 *
 * @author Logan Dutton-Anderson
 * @version 1.0
 */
public interface Movable {
    /**
     * Returns the speed of the movable object in miles per hour (MPH).
     *
     * @return the speed in miles per hour
     */
    double getSpeed();
}
