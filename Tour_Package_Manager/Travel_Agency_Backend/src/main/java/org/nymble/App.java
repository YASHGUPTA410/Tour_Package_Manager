package org.nymble;

import org.nymble.activity.Activity;
import org.nymble.activity.ActivityManagerIMPL;
import org.nymble.destination.Destination;
import org.nymble.destination.DestinationManager;
import org.nymble.destination.DestinationManagerIMPL;
import org.nymble.enums.Membership;
import org.nymble.passenger.Passenger;
import org.nymble.passenger.PassengerManager;
import org.nymble.passenger.PassengerManagerIMPL;
import org.nymble.tourPackage.TourPackage;
import org.nymble.tourPackage.TourPackageManager;
import org.nymble.tourPackage.TourPackageManagerIMPL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This is the Entry point of the application.
 * This contains all the static information about destinations ,activities, passengers etc etc.
 * @author  Yash Gupta
 * @version 1.0
 * @since   2023-12-30
 */

public class App 
{
    private static Map<Integer , TourPackage> tourPackageList ;
    private static List<Destination> destinationList;
    private static List<Activity> activitiesList;
    private static List<Passenger> passengerList;
    private static final TourPackageManager tourPackageManager = new TourPackageManagerIMPL();

    private static final PassengerManager passengerManager = new PassengerManagerIMPL(new ActivityManagerIMPL());

    private static final DestinationManager destinationManager = new DestinationManagerIMPL();


    public static void main( String[] args )
    {
        System.out.println( "  Welcome to Travel Agency Manager   " );
        System.out.println();
        // Setting up Mock Static Data 
        setUpTourPackages();
        setUpDestinations();
        setUpActivities();
        setUpPassengers();
        
        //Functionalities
        functionality1();
        functionality2();
        functionality3();
        functionality4();
        System.out.println("");
        System.out.println("");

        System.out.println("Thank you for the opportunity to work on this project. I've thoroughly enjoyed the " +
                "experience and believe the output reflects the dedication and effort put into it. " +
                "I look forward to any feedback or further discussions\n");
        System.out.println("");
        System.out.println( " Exiting The Application , Good bye " );
    }


    private static void functionality1() {
        // 01 : Print ternary of the travel package including details from id*
        System.out.println();
        System.out.println("Requirement 1 ");
        System.out.println("Package Name :: " + tourPackageList.get(1).getName());
        System.out.println("Destinations And Activities present :: " );
        System.out.println("");
        int destinationCount = 1;
        for (Destination destination : tourPackageList.get(1).getDestinationList()) {
            System.out.println("Destination " + destinationCount + " : " + destination.getName());
            System.out.println("Activities : [");
            System.out.println("");
            int activityCount = 1;
            for (Activity activity : destination.getActivityList()) {
                System.out.println("Activity " + activityCount + " {");
                System.out.println("name=" + activity.getName() + ",");
                System.out.println("id=" + activity.getId() + ",");
                System.out.println("description=" + activity.getDescription() + ",");
                System.out.println("cost=" + activity.getCost() + ",");
                System.out.println("capacity=" + activity.getCapacity() + " }");

                if (activityCount < destination.getActivityList().size()) {
                    System.out.println("");
                }
                activityCount++;
            }
            System.out.println("]");
            destinationCount++;
            System.out.println("");
        }
    }

    private static void functionality2() {
        System.out.println();
        System.out.println("Requirement 2 ");
        System.out.println("Package Name :: " + tourPackageList.get(2).getName());
        System.out.println("Passenger Capacity :: " + tourPackageList.get(2).getPassengerCapacity());
        System.out.println("Details of passenger currently enrolled in :: ");
        tourPackageList.get(1).getPassengerList().forEach(passenger -> {
            System.out.println("Passenger Name :: " + passenger.getName());
            System.out.println("Passenger Number :: " + passenger.getPassengerNum());
        });
    }
    private static void functionality3() {
        System.out.println();
        System.out.println("Requirement 3 ");
        System.out.println("Passenger Details ");
        int passengerCount = 1;

        for (Passenger passenger : passengerList) {
            System.out.println("Passenger " + passengerCount + " {");
            System.out.println("name=" + passenger.getName());
            System.out.println("passengerNum=" + passenger.getPassengerNum());
            System.out.println("membership=" + passenger.getMembership());
            System.out.println("balance=" + passenger.getBalance());
            System.out.println("destinationList : [");
            int destinationCount = 1;
            for (Destination destination : passenger.getDestinationList()) {
                System.out.println("Destination " + destinationCount + " {");
                System.out.println("name=" + destination.getName());
                System.out.println("id=" + destination.getId());
                System.out.println("activityList : [");
                int activityCount = 1;
                for (Activity activity : destination.getActivityList()) {
                    System.out.println("Activity " + activityCount + " {");
                    System.out.println("name=" + activity.getName());
                    System.out.println("id=" + activity.getId());
                    System.out.println("description=" + activity.getDescription());
                    System.out.println("cost=" + activity.getCost());
                    System.out.println("capacity=" + activity.getCapacity());
                    System.out.println("}");
                    if (activityCount < destination.getActivityList().size()) {
                        System.out.println(",");
                    }
                    activityCount++;
                }
                System.out.println("]");
                System.out.println("}");
                if (destinationCount < passenger.getDestinationList().size()) {
                    System.out.println(",");
                }
                destinationCount++;
            }
            System.out.println("]");
            System.out.println("activityList : [");
            int passengerActivityCount = 1;
            for (Activity activity : passenger.getActivityList()) {
                System.out.println("Activity " + passengerActivityCount + " {");
                System.out.println("name=" + activity.getName());
                System.out.println("id=" + activity.getId());
                System.out.println("description=" + activity.getDescription());
                System.out.println("cost=" + activity.getCost());
                System.out.println("capacity=" + activity.getCapacity());
                System.out.println("}");
                if (passengerActivityCount < passenger.getActivityList().size()) {
                    System.out.println(",");
                }
                passengerActivityCount++;
            }
            System.out.println("]");
            System.out.println("}");
            if (passengerCount < passengerList.size()) {
                System.out.println(",");
            }
            passengerCount++;
        }
        System.out.println("]");
    }
    private static void functionality4() {
        System.out.println();
        System.out.println("Requirement 4 ");
        System.out.println("Activities :: ");
        activitiesList.stream().forEach(activity -> {
            if(activity.getCapacity() > 0){
                System.out.println("Activity :: " + activity.getName());
                System.out.println("Capacity :: " + activity.getCapacity());
            }
        });
    }


    /**
     * Creating Fake Passengers
     */
    private static void setUpPassengers() {
        passengerList = new ArrayList<>();
        passengerList.add(
                Passenger.builder()
                        .passengerNum(1)
                        .name("Aashima Jain")
                        .balance(1000.0)
                        .membership(Membership.STANDARD)
                        .activityList(null)
                        .destinationList(null)
                        .build()
        );
        passengerList.add(
                Passenger.builder()
                        .passengerNum(2)
                        .name("Unnati Aggarwal")
                        .balance(100.0)
                        .membership(Membership.GOLD)
                        .activityList(null)
                        .destinationList(null)
                        .build()
        );
        passengerList.add(
                Passenger.builder()
                        .passengerNum(3)
                        .name("Yash Gupta")
                        .membership(Membership.PREMIUM)
                        .activityList(null)
                        .destinationList(null)
                        .build()
        );


        passengerManager.addDestination(destinationList.get(0) , passengerList.get(0));
        passengerManager.addDestination(destinationList.get(1) , passengerList.get(0));
        passengerManager.addDestination(destinationList.get(2) , passengerList.get(1));
        passengerManager.addDestination(destinationList.get(3) , passengerList.get(1));
        passengerManager.addDestination(destinationList.get(4) , passengerList.get(2));

        passengerManager.addActivity(passengerList.get(0) , activitiesList.get(0));
        passengerManager.addActivity(passengerList.get(0) , activitiesList.get(1));
        passengerManager.addActivity(passengerList.get(1) , activitiesList.get(5));
        passengerManager.addActivity(passengerList.get(2) , activitiesList.get(0));
        passengerManager.addActivity(passengerList.get(2) , activitiesList.get(1));
        passengerManager.addActivity(passengerList.get(2) , activitiesList.get(2));
        passengerManager.addActivity(passengerList.get(2) , activitiesList.get(3));

        tourPackageManager.addPassenger(passengerList.get(0) , tourPackageList.get(3));
        tourPackageManager.addPassenger(passengerList.get(1) , tourPackageList.get(1));
        tourPackageManager.addPassenger(passengerList.get(2) , tourPackageList.get(1));

    }


    /**
     * Creating Fake Activities
     */
    private static void setUpActivities() {
        activitiesList = new ArrayList<>();
        activitiesList.add(
                Activity.builder()
                        .id(1)
                        .name("Kimono Photo Session")
                        .description("Dress in traditional kimono attire and capture stunning photos in Kyoto's historic streets and gardens")
                        .capacity(20)
                        .cost(100.0)
                        .build()
                        );
        activitiesList.add(
                Activity.builder()
                        .id(2)
                        .name("Artistic Exploration")
                        .description("Discover ancient art forms and modern creative spaces")
                        .capacity(20)
                        .cost(100.0)
                        .build()
        );

        activitiesList.add(
                Activity.builder()
                        .id(3)
                        .name("Culinary Escape")
                        .description("Savor exquisite local flavors by the water's edge")
                        .capacity(20)
                        .cost(35.0)
                        .build()
        );
        activitiesList.add(
                Activity.builder()
                        .id(4)
                        .name("Mediterranean Culinary Delight")
                        .description("Indulge in Greek cuisine with a view of the sea")
                        .capacity(20)
                        .cost(35.0)
                        .build()
        );
        activitiesList.add(
                Activity.builder()
                        .id(5)
                        .name("Sunset Paradise")
                        .description("Enjoy romantic sunsets amid iconic white architecture.")
                        .capacity(10)
                        .cost(500.0)
                        .build()
        );

        activitiesList.add(
                Activity.builder()
                        .id(6)
                        .name("Adrenaline Coastline")
                        .description("Experience water sports and adventure along the coast")
                        .capacity(20)
                        .cost(35.0)
                        .build()
        );
        activitiesList.add(
                Activity.builder()
                        .id(7)
                        .name("Mountain Adventure")
                        .description("Hike through Rockies, kayak on pristine mountain lakes")
                        .capacity(20)
                        .cost(35.0)
                        .build()
        );
        activitiesList.add(
                Activity.builder()
                        .id(8)
                        .name("Cultural Serenity")
                        .description("Explore historic temples, gardens, tranquility")
                        .capacity(20)
                        .cost(35.0)
                        .build()
        );
        activitiesList.add(
                Activity.builder()
                        .id(9)
                        .name("Overwater Bliss")
                        .description("Relax in luxury overwater bungalows")
                        .capacity(20)
                        .cost(35.0)
                        .build()
        );
        destinationManager.addActivity(destinationList.get(0) , activitiesList.get(7));
        destinationManager.addActivity(destinationList.get(0) , activitiesList.get(5));
        destinationManager.addActivity(destinationList.get(1) , activitiesList.get(2));
        destinationManager.addActivity(destinationList.get(1) , activitiesList.get(3));
        destinationManager.addActivity(destinationList.get(1) , activitiesList.get(4));
        destinationManager.addActivity(destinationList.get(2) , activitiesList.get(5));
        destinationManager.addActivity(destinationList.get(2) , activitiesList.get(6));
        destinationManager.addActivity(destinationList.get(4) , activitiesList.get(7));
        destinationManager.addActivity(destinationList.get(3) , activitiesList.get(8));

    }

    /**
     * Creating Fake Destinations
     */
    private static void setUpDestinations() {
        destinationList = new ArrayList<>();
        destinationList.add(
                Destination.builder()
                        .id(1)
                        .name("Bora Bora, French Polynesia")
                        .activityList(null)
                        .build()
        );
        destinationList.add(
                Destination.builder()
                        .id(2)
                        .name("Kyoto, Japan")
                        .activityList(null)
                        .build()
        );
        destinationList.add(
                Destination.builder()
                        .id(3)
                        .name("Banff National Park, Canada")
                        .activityList(null)
                        .build()
        );destinationList.add(
                Destination.builder()
                        .id(4)
                        .name("Cape Town, South Africa")
                        .activityList(null)
                        .build()
        );
        destinationList.add(
                Destination.builder()
                        .id(5)
                        .name("Santorini, Greece")
                        .activityList(null)
                        .build()
        );

        tourPackageManager.addDestination(destinationList.get(0) , tourPackageList.get(1));
        tourPackageManager.addDestination(destinationList.get(1) , tourPackageList.get(3));
        tourPackageManager.addDestination(destinationList.get(2) , tourPackageList.get(2));
        tourPackageManager.addDestination(destinationList.get(3) , tourPackageList.get(2));
        tourPackageManager.addDestination(destinationList.get(4) , tourPackageList.get(1));
    }

    /**
     * Creating Tour Packages
     */
    private static void setUpTourPackages() {
        tourPackageList = new HashMap<>();
        tourPackageList.put(1 , TourPackage.builder()
                .id(1)
                .name("Greece")
                .passengerCapacity(500)
                .passengerList(null)
                .destinationList(null)
                .build());
        tourPackageList.put(2 , TourPackage.builder()
                .id(2)
                .name("South Africa")
                .passengerCapacity(500)
                .passengerList(null)
                .destinationList(null)
                .build());
        tourPackageList.put(3 , TourPackage.builder()
                .id(3)
                .name("Japan")
                .passengerCapacity(500)
                .passengerList(null)
                .destinationList(null)
                .build());
    }
}
