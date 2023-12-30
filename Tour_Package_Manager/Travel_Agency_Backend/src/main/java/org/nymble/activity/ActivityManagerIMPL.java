package org.nymble.activity;

import org.nymble.destination.Destination;
import java.util.List;


/**
 * @param activity
 * @return
 */
public class ActivityManagerIMPL implements ActivityManager{

    @Override
    public boolean addPassengerToActivity(Activity activity) {
        if(checkCapacity(activity)){
            activity.setCapacity(activity.getCapacity() - 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean checkCapacity(Activity activity) {
        return activity.getCapacity() > 0;
    }
}
