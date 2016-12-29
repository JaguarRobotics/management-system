package org.usd232.robotics.management.apis;

/**
 * The request to register a new user
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class RegisterRequest
{
    /**
     * The username of the new user
     * 
     * @since 1.0
     */
    public String username;
    /**
     * The first name of the new user
     * 
     * @since 1.0
     */
    public String fname;
    /**
     * The last name of the new user
     * 
     * @since 1.0
     */
    public String lname;
    /**
     * The password for the new user
     * 
     * @since 1.0
     */
    public String password;
    /**
     * The primary email for the new user
     * 
     * @since 1.0
     */
    public String email;
    /**
     * The secondary email for the new user
     * 
     * @since 1.0
     */
    public String email2;
    /**
     * The phone number for the new user
     * 
     * @since 1.0
     */
    public String phone;
    /**
     * The cellular provider for the new user
     * 
     * @since 1.0
     */
    public String provider;
}
