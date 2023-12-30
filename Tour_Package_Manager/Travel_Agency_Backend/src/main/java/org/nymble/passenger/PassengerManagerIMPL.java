package org.nymble.passenger;

import lombok.Data;
import org.nymble.activity.Activity;
import org.nymble.activity.ActivityManager;
import org.nymble.activity.ActivityManagerIMPL;
import org.nymble.destination.Destination;
import org.nymble.enums.Membership;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Data
public class PassengerManagerIMPL implements PassengerManager {
    private final ActivityManager activityManager;


    /**
     * @param passenger
     * @param activity
     * @return
     */
    @Override
    public boolean addActivity(Passenger passenger, Activity activity) {

        /*01 Check for destination*/
        /*Removed this validation as it is not required*/

        /* 02 : Check if Passenger has Balance*/
        boolean isBalanceAvailable = checkIfPassengerHasBalance(passenger , activity);


        /*03 : Check if Activity has Capacity*/
        boolean isCapacityAvailable = activityManager.checkCapacity(activity);
        /* 04 : Check Passenger Type and Activity Capacity to Reduce Balance */
        if(passenger.getMembership().equals(Membership.STANDARD) && isBalanceAvailable && isCapacityAvailable){
            passenger.setBalance(passenger.getBalance() - activity.getCost());
        } else if(passenger.getMembership().equals(Membership.GOLD) && isBalanceAvailable && isCapacityAvailable) {
            passenger.setBalance(passenger.getBalance() - activity.getCost() * 0.9);
        } else if(passenger.getMembership().equals(Membership.PREMIUM) && isCapacityAvailable){
            //Do Nothing as Premium member would not pay anything
        }else{
            //Return false as none of the above cases worked
            return false;
        }
        /*05 : Reduce Activity Capacity*/
        reduceCapacity(activity);

        /*06 Add activity to Passenger */
        addActivityInPassenger(passenger , activity);
        return true;
    }


    /**
     * @param passenger
     * @param activity
     * @return
     */
    private boolean checkIfPassengerHasBalance(Passenger passenger , Activity activity){
        /* 01: Check if passenger balance is greater than the cost of activity*/
        return passenger.getBalance() >= activity.getCost();
    }

    /**
     * @param passenger
     * @param activity
     */
    private void addActivityInPassenger(Passenger passenger , Activity activity){
        if(passenger.getActivityList() == null) {
            passenger.setActivityList(new ArrayList<>());
        }
        passenger.getActivityList().add(activity);
    }

    /**
     * @param activity
     */
    private void reduceCapacity(Activity activity){
        activityManager.addPassengerToActivity(activity);
    }

    /**
     * @param passenger
     * @return
     */
    @Override
    public double calculateActivityCost(Passenger passenger) {
        return passenger
                .getActivityList()
                .stream()
                .mapToDouble(Activity::getCost)
                .sum();
    }

    /**
     * @param destination
     * @param passenger
     */
    @Override
    public void addDestination(Destination destination, Passenger passenger) {
        if(passenger.getDestinationList() == null) {
            passenger.setDestinationList(new ArrayList<>());
        }
        passenger.getDestinationList().add(destination);
    }
}
