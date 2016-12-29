package org.usd232.robotics.management.apis;

/**
 * The model class representing a user
 * 
 * @author Zach Deibert
 * @since 1.0
 * @version 1.0
 */
public class User
{
    /**
     * The id of the user
     * 
     * @since 1.0
     */
    public int     id;
    /**
     * The name of the user
     * 
     * @since 1.0
     */
    public String  name;
    /**
     * The url to the picture of the user
     * 
     * @since 1.0
     */
    public String  picture;
    /**
     * If the user has been verified
     * 
     * @since 1.0
     */
    public Boolean verified;
    /**
     * The number of unexcused absences
     * 
     * @since 1.0
     */
    public int     unexcused;
    /**
     * The number of meetings the user has been late to
     * 
     * @since 1.0
     */
    public int     late;
}
