package org.usd232.robotics.management.apis.notifications;

/**
 * The notification settings relating to meetings
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class MeetingNotifications
{
    /**
     * If the member should get a notification for every meeting he/she misses
     * 
     * @since 1.0
     */
    public boolean missed;
    /**
     * If the member should get a reminder before every meeting
     * 
     * @since 1.0
     */
    public boolean reminders;
}
