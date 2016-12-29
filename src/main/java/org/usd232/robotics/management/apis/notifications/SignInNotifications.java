package org.usd232.robotics.management.apis.notifications;

/**
 * The notification settings relating to signing in
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class SignInNotifications
{
    /**
     * If the member should get a notification for every manual sign in
     * 
     * @since 1.0
     */
    public boolean manual;
    /**
     * If the member should get a notification for every automatic sign in
     * 
     * @since 1.0
     */
    public boolean auto;
}
