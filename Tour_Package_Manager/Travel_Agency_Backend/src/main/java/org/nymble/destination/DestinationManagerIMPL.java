package org.nymble.destination;

import org.nymble.activity.Activity;
import java.util.ArrayList;

/**
 * @param destination
 * @param activity
 * @return
 */
public class DestinationManagerIMPL implements DestinationManager{

    @Override
    public void addActivity(Destination destination, Activity activity) {
        if(destination.getActivityList() == null) {
            destination.setActivityList(new ArrayList<>());
        }
        destination.getActivityList().add(activity);
    }
}
