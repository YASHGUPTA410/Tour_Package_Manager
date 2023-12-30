package org.nymble.tourPackage;

import org.nymble.destination.Destination;
import org.nymble.passenger.Passenger;
import java.util.ArrayList;

// Implementation class or Service class for TourPackage

public class TourPackageManagerIMPL implements TourPackageManager{
    /**
     * @param passenger
     * @param tourPackage
     * @return
     */
    @Override
    public boolean addPassenger(Passenger passenger, TourPackage tourPackage) {
        /*01 : Check Capacity and ass passenger*/
        if(tourPackage.getPassengerCapacity() > 0){
            reducePassengerCapacity(tourPackage);
            addPassengerToTourPackage( passenger,  tourPackage);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param tourPackage
     */
    private void reducePassengerCapacity(TourPackage tourPackage) {
        tourPackage.setPassengerCapacity(tourPackage.getPassengerCapacity() - 1);
    }

    /**
     * @param destination
     * @param tourPackage
     * @return
     */
    @Override
    public boolean addDestination(Destination destination, TourPackage tourPackage) {
        return addDestinationToTourPackage(destination , tourPackage);
    }

    /**
     * @param destination
     * @param tourPackage
     * @return
     */
    private boolean addDestinationToTourPackage(Destination destination, TourPackage tourPackage) {
        if(tourPackage.getDestinationList() == null) {
            tourPackage.setDestinationList(new ArrayList<>());
        }
        return tourPackage.getDestinationList().add(destination);
    }

    /**
     * @param passenger
     * @param tourPackage
     */
    private void addPassengerToTourPackage(Passenger passenger, TourPackage tourPackage){
        if(tourPackage.getPassengerList() == null) {
            tourPackage.setPassengerList(new ArrayList<>());
        }
        tourPackage.getPassengerList().add(passenger);
    }
}
