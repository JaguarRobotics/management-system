package org.usd232.robotics.management.apis;

/**
 * The request to add a new contact method to a user
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class AddContactRequest
{
    /**
     * The type of contact
     * 
     * @since 1.0
     */
    public ContactType type;
    /**
     * The email address to send to (if it is an email contact)
     * 
     * @since 1.0
     */
    public String      address;
    /**
     * The phone number to send to (if it is a phone contact)
     * 
     * @since 1.0
     */
    public String      number;
    /**
     * The cellular provider (if it is a phone contact)
     * 
     * @since 1.0
     */
    public String      provider;
}
