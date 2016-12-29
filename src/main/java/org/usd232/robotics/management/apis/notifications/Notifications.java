package org.usd232.robotics.management.apis.notifications;

/**
 * The notification settings
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class Notifications
{
    /**
     * The notification settings relating to signing in
     * 
     * @since 1.0
     */
    public SignInNotifications  signIn;
    /**
     * If the member should be sent broadcast messages from the team
     * 
     * @since 1.0
     */
    public boolean              team;
    /**
     * The notification settings relating to meetings
     * 
     * @since 1.0
     */
    public MeetingNotifications meetings;
}
