package org.nymble.activity;

import org.nymble.destination.Destination;
import java.util.List;

public interface ActivityManager {
    boolean addPassengerToActivity(Activity activity);
    boolean checkCapacity(Activity activity);

}
