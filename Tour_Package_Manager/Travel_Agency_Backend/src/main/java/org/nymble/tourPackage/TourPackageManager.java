package org.nymble.tourPackage;

import org.nymble.destination.Destination;
import org.nymble.passenger.Passenger;

public interface TourPackageManager {
    boolean addPassenger(Passenger passenger ,TourPackage tourPackage);
    boolean addDestination(Destination destination , TourPackage tourPackage);
}
