package org.usd232.robotics.management.apis;

/**
 * The request to send a notification
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class NotificationRequest
{
    /**
     * The message to send
     * 
     * @since 1.0
     */
    public String             message;
    /**
     * The target to send the message to
     * 
     * @since 1.0
     */
    public NotificationTarget target;
}
