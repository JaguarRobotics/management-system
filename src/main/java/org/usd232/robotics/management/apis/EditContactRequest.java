package org.usd232.robotics.management.apis;

import org.usd232.robotics.management.apis.notifications.Notifications;

/**
 * The request to change the notification settings for a contact
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class EditContactRequest
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
     * The notification settings for this contact
     * 
     * @since 1.0
     */
    public Notifications notifications;
}
