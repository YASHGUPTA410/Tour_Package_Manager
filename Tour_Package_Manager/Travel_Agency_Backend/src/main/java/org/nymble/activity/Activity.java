package org.nymble.activity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.nymble.destination.Destination;

/**
 * Entity for Activity
 * @author  Yash Gupta
 * @version 1.0
 * @since   2023-12-30
 */

@Data
@Builder
public class Activity {
    private String name;
    @NonNull
    private final int id;
    private String description;
    @NonNull
    private double cost;
    private int capacity;

}
