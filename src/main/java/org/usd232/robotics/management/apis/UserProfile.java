package org.usd232.robotics.management.apis;

import java.util.List;

/**
 * A model object representing the profile of a user
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class UserProfile
{
    /**
     * The methods of contacting the user
     * 
     * @since 1.0
     */
    public List<UserContact> contact;
    /**
     * The url to the picture of the user
     * 
     * @since 1.0
     */
    public String            picture;
    /**
     * The pin number for the user to sign in to the kiosk with
     * 
     * @since 1.0
     */
    public int               pin;
}
