package org.nymble.Activity;

import org.junit.Assert;
import org.junit.Test;
import org.nymble.activity.Activity;
import org.nymble.activity.ActivityManagerIMPL;
import org.nymble.destination.Destination;

public class ActivityManagerIMPLTest {

    @Test
    public void testAddPassengerToActivity_Positive() {
        // Arrange
        ActivityManagerIMPL activityManager = new ActivityManagerIMPL();
        // Create an Activity object with positive capacity and cost
        Activity activity =
                Activity.builder()
                        .capacity(5)
                        .cost(20.0)
                        .id(1)
                        .description("Enjoy romantic sunsets amid iconic white architecture")
                        .name("Sunset Paradise")
                        .build();

        // Act
        boolean result = activityManager.addPassengerToActivity(activity);
        // Assert
        Assert.assertTrue(result);
        Assert.assertEquals(4, activity.getCapacity());
    }

    @Test
    public void testAddPassengerToActivity_Negative() {
        // Arrange
        ActivityManagerIMPL activityManager = new ActivityManagerIMPL();
        // Create an Activity object with positive capacity and cost
        Activity activity =
                Activity.builder()
                        .capacity(0)
                        .cost(20.0)
                        .id(1)
                        .description("Enjoy romantic sunsets amid iconic white architecture")
                        .name("Sunset Paradise")
                        .build();

        // Act
        boolean result = activityManager.addPassengerToActivity(activity);
        // Assert
        Assert.assertFalse(result);
        Assert.assertEquals(0, activity.getCapacity());
    }

    @Test
    public void testCheckCapacity_Positive() {
        // Arrange
        ActivityManagerIMPL activityManager = new ActivityManagerIMPL();
        // Create an Activity object with positive capacity and cost
        Activity activity =
                Activity.builder()
                        .capacity(1)
                        .cost(20.0)
                        .id(1)
                        .description("Enjoy romantic sunsets amid iconic white architecture")
                        .name("Sunset Paradise")
                        .build();

        // Act
        boolean result = activityManager.checkCapacity(activity);
        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void testCheckCapacity_Negative() {
        // Arrange
        ActivityManagerIMPL activityManager = new ActivityManagerIMPL();
        // Create an Activity object with positive capacity and cost
        Activity activity =
                Activity.builder()
                        .capacity(0)
                        .cost(20.0)
                        .id(1)
                        .description("Enjoy romantic sunsets amid iconic white architecture")
                        .name("Sunset Paradise")
                        .build();

        // Act
        boolean result = activityManager.checkCapacity(activity);
        // Assert
        Assert.assertFalse(result);
    }
}
