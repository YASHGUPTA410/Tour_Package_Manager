package org.nymble.passenger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.nymble.activity.Activity;
import org.nymble.destination.Destination;
import org.nymble.enums.Membership;
import java.util.List;

/**
 * Entity for Passenger
 * @author  Yash Gupta
 * @version 1.0
 * @since   2023-12-30
 */

@Data
@Builder
public class Passenger {
    private String name;
    @NonNull
    private final int passengerNum ;
    @NonNull
    private Membership membership;
    private double balance;
    private List<Destination> destinationList;
    private List<Activity> activityList;
}
