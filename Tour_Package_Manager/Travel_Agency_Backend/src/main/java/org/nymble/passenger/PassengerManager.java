package org.nymble.passenger;

import org.nymble.activity.Activity;
import org.nymble.destination.Destination;

public interface PassengerManager {
    boolean addActivity(Passenger passenger , Activity activity);
    double calculateActivityCost(Passenger passenger);
    void addDestination(Destination destination , Passenger passenger);
}
