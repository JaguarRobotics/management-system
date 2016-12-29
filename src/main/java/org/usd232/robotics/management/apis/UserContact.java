package org.usd232.robotics.management.apis;

import org.usd232.robotics.management.apis.notifications.Notifications;

/**
 * A model object representing a way of contacting the user
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class UserContact
{
    /**
     * The type of contact
     * 
     * @since 1.0
     */
    public ContactType   type;
    /**
     * The email address to send to (if it is an email contact)
     * 
     * @since 1.0
     */
    public String        address;
    /**
     * The phone number to send to (if it is a phone contact)
     * 
     * @since 1.0
     */
    public String        number;
    /**
     * The cellular provider (if it is a phone contact)
     * 
     * @since 1.0
     */
    public String        provider;
    /**
     * The notification settings for this contact
     * 
     * @since 1.0
     */
    public Notifications notifications;
}
