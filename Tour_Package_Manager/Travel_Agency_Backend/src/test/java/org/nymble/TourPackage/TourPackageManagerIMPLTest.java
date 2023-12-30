package org.nymble.TourPackage;

import org.junit.Assert;
import org.junit.Test;
import org.nymble.destination.Destination;
import org.nymble.enums.Membership;
import org.nymble.passenger.Passenger;
import org.nymble.tourPackage.TourPackage;
import org.nymble.tourPackage.TourPackageManagerIMPL;

public class TourPackageManagerIMPLTest {

    @Test
    public void testAddPassenger_Positive() {
        // Arrange
        TourPackageManagerIMPL tourPackageManager = new TourPackageManagerIMPL();
        Passenger passenger = Passenger.builder()
                .name("Yash")
                .passengerNum(1)
                .activityList(null)
                .membership(Membership.STANDARD)
                .balance(100.0)
                .build();
        TourPackage tourPackage =
                TourPackage.builder()
                                .id(1)
                                .destinationList(null)
                                .passengerList(null)
                                .name("Greece")
                                .passengerCapacity(1)
                                .build();


        // Act
        boolean result = tourPackageManager.addPassenger(passenger, tourPackage);
        // Assert
        Assert.assertTrue(result);
        Assert.assertEquals(0, tourPackage.getPassengerCapacity());
        Assert.assertEquals(1, tourPackage.getPassengerList().size());
        Assert.assertTrue(tourPackage.getPassengerList().contains(passenger));
    }

    @Test
    public void testAddPassenger_Negative() {
        // Arrange
        TourPackageManagerIMPL tourPackageManager = new TourPackageManagerIMPL();
        Passenger passenger = Passenger.builder()
                .name("Yash")
                .passengerNum(1)
                .activityList(null)
                .membership(Membership.STANDARD)
                .balance(100.0)
                .build();
        TourPackage tourPackage =
                TourPackage.builder()
                        .id(1)
                        .destinationList(null)
                        .passengerList(null)
                        .name("Greece")
                        .passengerCapacity(0)
                        .build();


        // Act
        boolean result = tourPackageManager.addPassenger(passenger, tourPackage);
        // Assert
        Assert.assertFalse(result);
        Assert.assertEquals(0, tourPackage.getPassengerCapacity());
        Assert.assertNull(tourPackage.getPassengerList());
    }

    @Test
    public void testAddDestination() {
        // Arrange
        TourPackageManagerIMPL tourPackageManager = new TourPackageManagerIMPL();
        Destination destination =
                Destination.builder()
                        .name("Santorini, Greece")
                        .id(1).build();
        TourPackage tourPackage =
                TourPackage.builder()
                        .id(1)
                        .destinationList(null)
                        .passengerList(null)
                        .name("Greece")
                        .passengerCapacity(1)
                        .build();

        // Act
        boolean result = tourPackageManager.addDestination(destination, tourPackage);
        // Assert
        Assert.assertTrue(result);
        Assert.assertEquals(1, tourPackage.getDestinationList().size());
        Assert.assertTrue(tourPackage.getDestinationList().contains(destination));
    }
}
