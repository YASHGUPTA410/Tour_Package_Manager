package org.nymble.Passenger;

import org.junit.Test;
import org.nymble.activity.Activity;
import org.nymble.activity.ActivityManagerIMPL;
import org.nymble.destination.Destination;
import org.nymble.enums.Membership;
import org.nymble.passenger.Passenger;
import org.nymble.passenger.PassengerManagerIMPL;



import static org.junit.Assert.*;

public class PassengerManagerIMPLTest {

    @Test
    public void testAddActivity_StandardMembership() {
        // Create a Passenger object with Standard membership
        Passenger passenger = Passenger.builder()
                .name("Yash")
                .passengerNum(1)
                .activityList(null)
                .destinationList(null)
                .membership(Membership.STANDARD)
                .balance(100.0)
                .build();

        //Create a destination
        Destination destination =  Destination.builder()
                            .id(1)
                            .name("Santorini, Greece")
                            .build();


        // Create an Activity object with positive capacity and cost
        Activity activity =
                Activity.builder()
                        .capacity(5)
                        .cost(20.0)
                        .id(1)
                        .description("Explore historic temples, gardens, tranquility")
                        .name("Cultural Serenity")
                        .build();

        // Create an instance of PassengerManagerIMPL
        PassengerManagerIMPL passengerManager = new PassengerManagerIMPL(new ActivityManagerIMPL());
        //Add Desination first
        passengerManager.addDestination(destination , passenger);
        // Add the activity to the passenger
        boolean result = passengerManager.addActivity(passenger, activity);
        // Assert that the addition of the activity is successful
        assertTrue(result);
        // Assert that the passenger's balance is reduced by the activity cost
        assertEquals(80.0, passenger.getBalance(), 0.0);
        // Assert that the activity's capacity is reduced by 1
        assertEquals(4, activity.getCapacity());
        // Assert that the activity is added to the passenger's activity list
        assertTrue(passenger.getActivityList().contains(activity));
    }

    @Test
    public void test_calculateActivityCost(){
        Passenger passenger = Passenger.builder()
                .name("Unnati Aggarwal")
                .passengerNum(1)
                .activityList(null)
                .membership(Membership.STANDARD)
                .balance(20.0)
                .build();


        //Create a destination
        Destination destination =  Destination.builder()
                .id(1)
                .name("Bora Bora, French Polynesia")
                .build();

        // Create an Activity object with positive capacity and cost
        Activity activity1 =
                Activity.builder()
                        .capacity(5)
                        .cost(20.0)
                        .id(1)
                        .description("Hike through Rockies, kayak on pristine mountain lakes")
                        .name("Mountain Adventure")
                        .build();

        // Create an Activity object with positive capacity and cost
        Activity activity2 =
                Activity.builder()
                        .capacity(5)
                        .cost(20.0)
                        .id(1)
                        .description("Experience water sports and adventure along the coast")
                        .name("Adrenaline Coastline")
                        .build();

        // Create an instance of PassengerManagerIMPL
        PassengerManagerIMPL passengerManager = new PassengerManagerIMPL(new ActivityManagerIMPL());
        //Add Desination first
        passengerManager.addDestination(destination , passenger);
        // Add the activity to the passenger
        boolean addFirstActivity = passengerManager.addActivity(passenger, activity1);
        boolean addSecondActivity = passengerManager.addActivity(passenger, activity1);
        assertTrue(addFirstActivity);
        assertFalse(addSecondActivity);
        double sum = passengerManager.calculateActivityCost(passenger);
        assertEquals(20.0,sum,0.0);
    }
}
